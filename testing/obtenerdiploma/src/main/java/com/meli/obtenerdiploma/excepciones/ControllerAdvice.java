package com.meli.obtenerdiploma.excepciones;

import com.meli.obtenerdiploma.model.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {
        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<ErrorDTO> argumentNotValid(MethodArgumentNotValidException invalidate){
            ErrorDTO errorDTO = new ErrorDTO();
            errorDTO.setName("Parametro de entrada no valido");
            errorDTO.setDescription(invalidate.getMessage());
            return new ResponseEntity<ErrorDTO>(errorDTO, HttpStatus.BAD_REQUEST);
        }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorDTO> notReadable(HttpMessageNotReadableException invalidate){
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setName("Parametro de entrada no valido");
        errorDTO.setDescription(invalidate.getMessage());
        return new ResponseEntity<ErrorDTO>(errorDTO, HttpStatus.BAD_REQUEST);
    }
}
