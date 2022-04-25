package com.blog.blog.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerAdviceExceptions extends ResponseEntityExceptionHandler {
        @ExceptionHandler(value = {BlogDuplicadoException.class})
        protected ResponseEntity<Object> DuplicateException(RuntimeException ex){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }

        @ExceptionHandler(value = {BlogNotFoundException.class})
        protected  ResponseEntity<Object> NotFoundException(RuntimeException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
}
