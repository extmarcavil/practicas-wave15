package com.meli.obtenerdiploma.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionController  {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ErrorDTO> handleMethodArgumentNotValid(MethodArgumentNotValidException e){
        var response = new ErrorDTO(e.getFieldError(e.getFieldError().getField()).getDefaultMessage(),e.getFieldError().getField(), HttpStatus.BAD_REQUEST.toString());
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    protected ResponseEntity<ErrorDTO> handleValidationExceptions(HttpMessageNotReadableException e){
        var response = new ErrorDTO(e.getMessage(),null, HttpStatus.BAD_REQUEST.toString());
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }
}
