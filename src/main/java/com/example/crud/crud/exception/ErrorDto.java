package com.example.crud.crud.exception;

import org.springframework.http.HttpStatus;

import java.time.LocalDate;

public class ErrorDto {
    private String message;
    private HttpStatus status;
    private String code;

    public ErrorDto(String message, HttpStatus status, String code) {
        this.message = message;
        this.status = status;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
