package com.Spring.LinkTracker.exception;

import com.Spring.LinkTracker.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(LinkAlreadyInvalidated.class)
    public ResponseEntity<ErrorDTO> handlerAlreadyInvalidException(LinkAlreadyInvalidated e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorDTO(e.getMessage(),HttpStatus.BAD_REQUEST));
    }

    @ExceptionHandler(IdNotFound.class)
    public ResponseEntity<ErrorDTO> handlerNotFoundException(IdNotFound e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorDTO(e.getMessage(),HttpStatus.NOT_FOUND));
    }

    @ExceptionHandler(UrlAlreadyExists.class)
    public ResponseEntity<ErrorDTO> handlerUrlExistsException(UrlAlreadyExists e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorDTO(e.getMessage(),HttpStatus.NOT_FOUND));
    }
}
