package com.sprint1.be_java_hisp_w15_g03.exception;

import com.sprint1.be_java_hisp_w15_g03.dto.response.ErrorDTO;
import com.sprint1.be_java_hisp_w15_g03.dto.response.ErrorValidationDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@ControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(PersonNotFoundException.class)
    ResponseEntity<ErrorDTO> handlerExceptionPersonNotFound(PersonNotFoundException personNotFound){
        ErrorDTO errorDTO = new ErrorDTO("Entidad no encontrada", personNotFound.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RelationConflictException.class)
    ResponseEntity<ErrorDTO> handlerExceptionRelationNotFound(RelationConflictException relationNotFound){
        ErrorDTO errorDTO = new ErrorDTO("Fallo en ralacion esperada", relationNotFound.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    ResponseEntity<ErrorDTO> handlerExceptionCategoryNotFound(CategoryNotFoundException categoryNotFound){
        ErrorDTO errorDTO = new ErrorDTO("Fallo en categoria esperada", categoryNotFound.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(OrderInvalidException.class)
    ResponseEntity<ErrorDTO> handlerExceptionRelationNotFound(OrderInvalidException orderInvalidException){
        ErrorDTO errorDTO = new ErrorDTO("Error en metodo de orden", orderInvalidException.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProductDuplicatedException.class)
    ResponseEntity<ErrorDTO> handlerExceptionProductDuplicated(ProductDuplicatedException productDuplicatedException){
        ErrorDTO errorDTO = new ErrorDTO("Error en parametros de entrada", productDuplicatedException.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    protected ResponseEntity<ErrorDTO> handleValidationExceptions(HttpMessageNotReadableException e) {
        ErrorDTO error = new ErrorDTO("HttpMessageNotReadableException", e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<ErrorValidationDTO> validationsException ( MethodArgumentNotValidException exception ) {
        HashMap<String, List<String>> errors = getHashMapErrors(exception.getFieldErrors());

        ErrorValidationDTO errorDTO = new ErrorValidationDTO("Some Input are Invalids", errors);
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    private HashMap<String, List<String>> getHashMapErrors ( List<FieldError> errors ) {
        HashMap<String, List<String>> errorsList = new HashMap<>();
        errors.forEach(e -> {
            String field = e.getField();
            String msg   = e.getDefaultMessage();
            List<String> errorFields = new ArrayList<>();
            if (errorsList.containsKey(e.getField())) {
                errorFields = errorsList.get(field);
            }
            errorFields.add(msg);
            errorsList.put(field, errorFields);
        });
        return errorsList;
    }
}

