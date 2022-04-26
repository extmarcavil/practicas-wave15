package com.linktacker.linktacker.exception;

import com.linktacker.linktacker.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdviceClient {
    @ExceptionHandler(PaginaException.class)
    public ResponseEntity<ErrorDTO> EntradaBlogDuplicadaException(Exception e){
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setMensaje("Datos Incorrectos - Id y/o Password " );
        errorDTO.setEstatus(false);
        return new ResponseEntity<ErrorDTO>(errorDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PaginaInvalidaExeption.class)
    public ResponseEntity<ErrorDTO> PaginaInvalidaExeption(Exception e){
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setMensaje("La pagina se encuentra invalidada" );
        errorDTO.setEstatus(false);
        return new ResponseEntity<ErrorDTO>(errorDTO, HttpStatus.NOT_FOUND);
    }
}
