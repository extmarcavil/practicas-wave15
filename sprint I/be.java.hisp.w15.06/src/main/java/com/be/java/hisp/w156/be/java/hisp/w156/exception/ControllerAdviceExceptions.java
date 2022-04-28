package com.be.java.hisp.w156.be.java.hisp.w156.exception;

import com.be.java.hisp.w156.be.java.hisp.w156.dto.response.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerAdviceExceptions extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {UserNotFoundException.class})
    protected ResponseEntity<Object> NotFoundException(RuntimeException ex){
        ErrorDTO error = new ErrorDTO("UserNotFoundException", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(value = {OrderNotFoundException.class})
    protected ResponseEntity<Object> OrderNotFoundException(RuntimeException ex){
        ErrorDTO error = new ErrorDTO("OrderNotFoundException", ex.getMessage());
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

}
