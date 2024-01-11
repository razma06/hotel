package com.exam.giorgi_razmadze.exception.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class SystemException extends RuntimeException {

    private final String code;
    private final HttpStatus status;

    public SystemException(String code, String message, HttpStatus status) {
        super(message);
        this.code = code;
        this.status = status;
    }


}
