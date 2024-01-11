package com.exam.giorgi_razmadze.exception.model;


import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@ControllerAdvice
@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RestExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleError(Exception ex) {
        log.error("Internal Error", ex);
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage().equals("Access is denied") ? HttpStatus.FORBIDDEN : HttpStatus.INTERNAL_SERVER_ERROR);
        errorResponse.setMessageCode("internal.server.error");
        errorResponse.setMessageDescription(ex.getLocalizedMessage());
        logError(errorResponse);
        errorResponse.setMessageDescription(ex.getMessage().equals("Access is denied") ? ex.getMessage() : "Unexpected error occurred");
        return buildResponseEntity(errorResponse);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleError(MethodArgumentNotValidException e) {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST);
        final List<String> errors = new ArrayList<String>();
        for (final FieldError error : e.getBindingResult().getFieldErrors()) {
            errors.add(error.getField() + ": " + error.getDefaultMessage());
        }
        for (final ObjectError error : e.getBindingResult().getGlobalErrors()) {
            errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
        }
        errorResponse.setMessageCode("validation.error");
        errorResponse.setMessageDescription(errors.toString());
        return buildResponseEntity(errorResponse);
    }

    @ExceptionHandler(SystemException.class)
    public ResponseEntity<Object> handleError(SystemException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getStatus());
        errorResponse.setMessageCode(ex.getCode());
        errorResponse.setMessageDescription(ex.getLocalizedMessage());
        logError(errorResponse);
        return buildResponseEntity(errorResponse);
    }

    private ResponseEntity<Object> buildResponseEntity(ErrorResponse errorResponse) {
        return new ResponseEntity<>(errorResponse, errorResponse.getStatus());
    }

    private void logError(ErrorResponse errorResponse) {
        if (log.isErrorEnabled()) {
            log.error(errorResponse.toString());
        } else {
            log.info(errorResponse.toString());
        }
    }

}
