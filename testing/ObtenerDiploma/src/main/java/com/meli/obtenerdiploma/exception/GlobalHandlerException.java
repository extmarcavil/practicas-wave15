package com.meli.obtenerdiploma.exception;

import com.meli.obtenerdiploma.model.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;

public class GlobalHandlerException {

    ResponseEntity<ErrorDTO> validations(MethodArgumentNotValidException ex){
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setName("Entrada es invalida");
        errorDTO.setDescription(ex.getFieldError().getDefaultMessage());

        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }
}
