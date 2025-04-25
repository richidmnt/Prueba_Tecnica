package com.example.crud.crud.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionControll {


    @ExceptionHandler(BusinnesException.class)
    public ResponseEntity<Map<String,Object>> businnesExeption(BusinnesException e, WebRequest webRequest){
        Map<String,Object> error = new HashMap<>();
        error.put("timestamp", LocalDateTime.now());
        error.put("status", e.getHttpStatus().value());
        error.put("error", "Not_Found");
        error.put("message", e.getMessage());
        error.put("path",webRequest.getDescription(false));

        return ResponseEntity.status(e.getHttpStatus()).body(error);
    }
     @ExceptionHandler(MethodArgumentNotValidException.class)
     public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
            Map<String, String> errors = new HashMap<>();
            ex.getBindingResult().getFieldErrors().forEach(error->{
                errors.put(error.getField(), error.getDefaultMessage());
            });         
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
     }
}
