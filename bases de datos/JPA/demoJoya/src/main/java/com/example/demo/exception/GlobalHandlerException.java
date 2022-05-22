package com.example.demo.exception;


import com.example.demo.DTO.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(JewelNotFoundException.class)
    ResponseEntity<ErrorDTO> handlerExceptionTestNotFound(JewelNotFoundException testNotFound){
        ErrorDTO errorDTO = new ErrorDTO("Entidad no encontrada", testNotFound.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
    }
}