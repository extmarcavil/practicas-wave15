package com.meli.obtenerdiploma.exception;

import org.apache.coyote.Response;
import org.springframework.http.HttpMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



public class ExceptionGlobal extends ResponseEntityExceptionHandler {

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    protected ResponseEntity<CustomException> handleValidationExceptions(MethodArgumentNotValidException ex) {
//        //define custom exception and return correspondant HttpStatus
//        return new ResponseEntity<>(customException, HttpStatus.BAD_REQUEST);
//    }
//
//    @ExceptionHandler(HttpMessageNotReadableException.class)
//    protected ResponseEntity<CustomException> handleValidationExceptions(HttpMessageNotReadableException ex) {
//        CustomException customException = new CustomException("Custom message", ex.getMessage());
//        return new ResponseEntity<>(customException, HttpStatus.BAD_REQUEST);
//    }
}