package com.example.be_java_hisp_w15_g07_sclerandi.exception;

import com.example.be_java_hisp_w15_g07_sclerandi.dto.response.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(UserNotFoundException.class)
    ResponseEntity<ErrorDTO> handlerExceptionNotFound(UserNotFoundException e){
        ErrorDTO errorDTO = new ErrorDTO("Usuario no encontrado", e.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    ResponseEntity<ErrorDTO> handlerExceptionNotFound(BadRequestException e){
        ErrorDTO errorDTO = new ErrorDTO("Peticion invalida", e.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }



}
