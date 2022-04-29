package com.meli.obtenerdiploma.exception;

import org.springframework.beans.NotReadablePropertyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandlers{

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<CustomException> handlerValidationExceptions(MethodArgumentNotValidException ex){
        CustomException customException = new CustomException("Se produjo un error!",ex.getBindingResult().getFieldError().getDefaultMessage());
        return new ResponseEntity<>(customException, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    protected ResponseEntity<CustomException> handlerValidationExceptions(HttpMessageNotReadableException ex){
        CustomException customException = new CustomException("Se produjo otro error!",ex.getMessage());
        return new ResponseEntity<>(customException, HttpStatus.BAD_REQUEST);
    }
}
