package com.meli.responseentity.persondto.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class ExceptionApiHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = SportNotFoundException.class)
    public ResponseEntity<?> sportNotFoundException(SportNotFoundException sportNotFoundException) {
        return new ResponseEntity<>(sportNotFoundException.getMessage(), NOT_FOUND);
    }

}
