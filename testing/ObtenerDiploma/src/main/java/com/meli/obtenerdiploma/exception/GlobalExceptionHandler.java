package com.meli.obtenerdiploma.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ExceptionDTO> handleValidationExceptions(MethodArgumentNotValidException e){
        List<FieldErrorDTO> fields = e.getBindingResult().getFieldErrors().stream()
                .map(v -> new FieldErrorDTO(v.getField(), v.getDefaultMessage()))
                .collect(Collectors.toList());
        ExceptionDTO exception = new ExceptionDTO("Validation Error", fields);
        return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
    }
}
