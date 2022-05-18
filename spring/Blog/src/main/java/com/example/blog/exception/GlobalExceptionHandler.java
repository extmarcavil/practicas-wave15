package com.example.blog.exception;

import com.example.blog.DTO.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<ErrorDTO> handlerNotFoundException(IdNotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorDTO(e.getMessage(),HttpStatus.NOT_FOUND));
    }

    @ExceptionHandler(BlogAlreadyExists.class)
    public ResponseEntity<ErrorDTO> handlerBlogExistsException(BlogAlreadyExists e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorDTO(e.getMessage(),HttpStatus.BAD_REQUEST));
    }
}
