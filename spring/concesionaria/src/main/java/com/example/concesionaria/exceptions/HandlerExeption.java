package com.example.concesionaria.exceptions;

import com.example.concesionaria.dto.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandlerExeption {
    @ExceptionHandler(NotFoundException.class)
    ResponseEntity<ErrorResponseDTO> handlerNotFoundException(NotFoundException e){
        ErrorResponseDTO errorResponse = new ErrorResponseDTO("Entidad inexistente", e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
