package com.sprint.be_java_hisp_w15_g10.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(RuntimeException.class)
    ResponseEntity<ErrorDTO> handlerException (UserNotFoundException exception ) {
        ErrorDTO errorDTO = new ErrorDTO("ERROR", exception.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
    }
}
