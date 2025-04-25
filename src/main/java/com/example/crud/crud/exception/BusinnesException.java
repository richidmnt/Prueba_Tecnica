package com.example.crud.crud.exception;

import org.springframework.http.HttpStatus;

public class BusinnesException extends RuntimeException {
    private String code;
    private HttpStatus httpStatus;

    public BusinnesException(String message,HttpStatus httpStatus, String code) {
        super(message);
        this.code = code;
        this.httpStatus =  httpStatus;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
