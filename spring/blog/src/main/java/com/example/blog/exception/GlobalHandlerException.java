package com.example.blog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(AlreadyExistException.class)
    public ResponseEntity<ErrorDTO> handlerException(AlreadyExistException exception){
        return getErrorDTOResponseEntity(exception, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorDTO> handlerException(NotFoundException exception){
        return getErrorDTOResponseEntity(exception, HttpStatus.NOT_FOUND);
    }

    private ResponseEntity<ErrorDTO> getErrorDTOResponseEntity(Exception exception, HttpStatus status) {
        ErrorDTO error = new ErrorDTO("Error", exception.getMessage());
        return new ResponseEntity<>(error, status);
    }
}
