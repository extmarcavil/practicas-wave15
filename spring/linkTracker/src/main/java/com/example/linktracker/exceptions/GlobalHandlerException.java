package com.example.linktracker.exceptions;

import com.example.linktracker.dto.response.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandlerException {
    @ExceptionHandler({InvalidUrlException.class})
    public ResponseEntity<ExceptionDTO> handleException(InvalidUrlException exception){
        ExceptionDTO error = new ExceptionDTO("Error", exception.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
