package com.meli.blog.exceptions;

import com.meli.blog.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorDto> blogAlreadyExistsException(BlogAlreadyExistsException exception) {
        return new ResponseEntity<>(ErrorDto.from(exception), HttpStatus.CONFLICT);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorDto> blogDoesNotExistException(BlogDoesNotExistException exception) {
        return new ResponseEntity<>(ErrorDto.from(exception), HttpStatus.NOT_FOUND);
    }
}
