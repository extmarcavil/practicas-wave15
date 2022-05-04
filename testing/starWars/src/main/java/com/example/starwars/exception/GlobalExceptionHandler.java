package com.example.starwars.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BadQueryException.class)
    public ResponseEntity<ErrorDTO> handleException(BadQueryException e){
        return new ResponseEntity<>(
                new ErrorDTO(e.getClass().getSimpleName(), e.getMessage()),
                HttpStatus.BAD_REQUEST
        );
    }
}
