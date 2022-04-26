package com.bootcamp.linktracker.exception;

import com.bootcamp.linktracker.dtos.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(NotFoundException.class)
    ResponseEntity<ErrorDTO> handlerExceptionNotFound(NotFoundException notFoundException){
        ErrorDTO errorDTO = new ErrorDTO("Entidad no encontrada", notFoundException.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    ResponseEntity<ErrorDTO> handlerExceptionIlegalArgument(IllegalArgumentException illegalArgumentException){
        ErrorDTO errorDTO = new ErrorDTO("Formato invalido", illegalArgumentException.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnauthorizedException.class)
    ResponseEntity<ErrorDTO> handlerExceptionUnauthorized(UnauthorizedException unauthorizedException){
        ErrorDTO errorDTO = new ErrorDTO("Acceso denegado", unauthorizedException.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }
}
