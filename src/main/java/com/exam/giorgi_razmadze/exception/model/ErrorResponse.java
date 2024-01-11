package com.exam.giorgi_razmadze.exception.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class ErrorResponse {

    private HttpStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    private String messageCode;
    private String messageDescription;

    private ErrorResponse() {
        timestamp = LocalDateTime.now();
    }

    public ErrorResponse(HttpStatus status) {
        this();
        this.status = status;
    }

    public ErrorResponse(HttpStatus status, Throwable ex) {
        this();
        this.status = status;
        this.messageCode = "Unexpected error";
        this.messageDescription = ex.getLocalizedMessage();
    }

    public ErrorResponse(HttpStatus status, String messageCode, Throwable ex) {
        this();
        this.status = status;
        this.messageCode = messageCode;
        this.messageDescription = ex.getLocalizedMessage();
    }

}
