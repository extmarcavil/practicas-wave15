package com.bootcamp.testing.exception.handler;

import com.bootcamp.testing.dto.ExceptionDTO;
import com.bootcamp.testing.exception.notfound.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(NotFoundException.class)
    ResponseEntity<ExceptionDTO> recipeNotFoundException(NotFoundException ex){

        ExceptionDTO exceptionDTO = new ExceptionDTO();
        exceptionDTO.setException(ex.getException());
        exceptionDTO.setStatus(ex.getStatus());
        exceptionDTO.setMessageException(ex.getMessage());

        return new ResponseEntity<>(exceptionDTO, ex.getStatus());
    }
}
