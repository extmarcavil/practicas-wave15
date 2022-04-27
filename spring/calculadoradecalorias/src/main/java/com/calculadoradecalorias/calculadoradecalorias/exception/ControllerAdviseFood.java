package com.calculadoradecalorias.calculadoradecalorias.exception;

import com.calculadoradecalorias.calculadoradecalorias.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdviseFood {

    @ExceptionHandler(NotFoudIngrediente.class)
    public ResponseEntity<ErrorDTO> notFoundIngredient(NotFoudIngrediente e){
        ErrorDTO errorDTO= new ErrorDTO();
        errorDTO.setName("Ingrediente no encontrado");
        errorDTO.setDescripcion(e.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NotFoudFood.class)
    public ResponseEntity<ErrorDTO> notFoundFood(NotFoudFood e){
        ErrorDTO errorDTO= new ErrorDTO();
        errorDTO.setName("Plato no encontrado");
        errorDTO.setDescripcion(e.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
    }
}
