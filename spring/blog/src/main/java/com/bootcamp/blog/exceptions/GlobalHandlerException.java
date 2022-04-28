package com.bootcamp.blog.exceptions;

import com.bootcamp.blog.dtos.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(AlreadyExistsException.class)
    ResponseEntity<ErrorDTO> handlerException(AlreadyExistsException alreadyExistsException){
        ErrorDTO errorDTO = new ErrorDTO("Entidad duplicada", alreadyExistsException.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.ALREADY_REPORTED);
    }

    @ExceptionHandler(NotFoundException.class)
    ResponseEntity<ErrorDTO> handlerExceptionNotFound(NotFoundException notFoundException){
        ErrorDTO errorDTO = new ErrorDTO("Entidad no encontrada", notFoundException.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
    }

}
