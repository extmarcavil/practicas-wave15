package com.sprint1.be_java_hisp_w15_g03.exception;

import com.sprint1.be_java_hisp_w15_g03.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(PersonNotFound.class)
    ResponseEntity<ErrorDTO> handlerExceptionPersonNotFound(PersonNotFound personNotFound){
        ErrorDTO errorDTO = new ErrorDTO("Entidad no encontrada", personNotFound.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RelationNotFound.class)
    ResponseEntity<ErrorDTO> handlerExceptionRelationNotFound(RelationNotFound relationNotFound){
        ErrorDTO errorDTO = new ErrorDTO("Fallo en ralacion esperada", relationNotFound.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(OrderInvalidException.class)
    ResponseEntity<ErrorDTO> handlerExceptionRelationNotFound(OrderInvalidException orderInvalidException){
        ErrorDTO errorDTO = new ErrorDTO("Error en metodo de orden", orderInvalidException.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
    }

}
