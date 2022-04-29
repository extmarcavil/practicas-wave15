package com.meli.obtenerdiploma.exception;

import com.meli.obtenerdiploma.model.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ErrorDTO> handleValidationExceptions(MethodArgumentNotValidException methodArgumentNotValidException){
        ErrorDTO errorDTO = new ErrorDTO("Error en validación", methodArgumentNotValidException.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    protected ResponseEntity<ErrorDTO> handleValidationHttpExceptions(HttpMessageNotReadableException httpMessageNotReadableException){
        ErrorDTO errorDTO = new ErrorDTO("Error en validación", httpMessageNotReadableException.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }
}
