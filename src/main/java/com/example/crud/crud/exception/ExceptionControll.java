package com.example.crud.crud.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControll {

    @ExceptionHandler(BusinnesException.class)
    public ResponseEntity<ErrorDto> businnesExeption(BusinnesException e){
        ErrorDto errorDto = new ErrorDto(e.getMessage(),e.getHttpStatus(),e.getCode());
        return new ResponseEntity<>(errorDto, errorDto.getStatus());

    }
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String>  handlerException(RuntimeException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}
