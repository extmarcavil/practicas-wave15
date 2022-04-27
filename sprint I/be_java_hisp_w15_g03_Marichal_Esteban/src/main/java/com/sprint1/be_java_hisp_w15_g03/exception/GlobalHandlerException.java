package com.sprint1.be_java_hisp_w15_g03.exception;

import com.sprint1.be_java_hisp_w15_g03.dto.response.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(PersonNotFoundException.class)
    ResponseEntity<ErrorDTO> handlerExceptionPersonNotFound(PersonNotFoundException personNotFound){
        ErrorDTO errorDTO = new ErrorDTO("Entidad no encontrada", personNotFound.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RelationConflictException.class)
    ResponseEntity<ErrorDTO> handlerExceptionRelationConflict(RelationConflictException relationNotFound){
        ErrorDTO errorDTO = new ErrorDTO("Fallo en ralacion esperada", relationNotFound.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    ResponseEntity<ErrorDTO> handlerExceptionCategoryNotFound(CategoryNotFoundException categoryNotFound){
        ErrorDTO errorDTO = new ErrorDTO("Fallo en categoria esperada", categoryNotFound.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(OrderInvalidException.class)
    ResponseEntity<ErrorDTO> handlerExceptionOrderInvalid(OrderInvalidException orderInvalidException){
        ErrorDTO errorDTO = new ErrorDTO("Error en metodo de orden", orderInvalidException.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProductDuplicatedException.class)
    ResponseEntity<ErrorDTO> handlerExceptionProductDuplicated(ProductDuplicatedException productDuplicatedException){
        ErrorDTO errorDTO = new ErrorDTO("Error en parametros de entrada", productDuplicatedException.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.CONFLICT);
    }


}
