package com.meli.TestCase.exception;


import com.meli.TestCase.Dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(TestNotFoundException.class)
    ResponseEntity<ErrorDTO> handlerExceptionTestNotFound(TestNotFoundException testNotFound){
        ErrorDTO errorDTO = new ErrorDTO("Entidad no encontrada", testNotFound.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
    }
}