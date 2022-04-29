package com.meli.obtenerdiploma.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<InvalidArgumentException> handleValidationExceptions(MethodArgumentNotValidException e) {
        InvalidArgumentException exception = new InvalidArgumentException("Argumento invalido:",e.getFieldError().getDefaultMessage());
        return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    protected ResponseEntity<InvalidArgumentException> handleValidationExceptions(HttpMessageNotReadableException e) {
        InvalidArgumentException exception = new InvalidArgumentException("Argumento invalido:",e.getMessage());
        return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
    }
}