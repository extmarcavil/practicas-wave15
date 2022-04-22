package com.apiblog.exceptions;
import com.apiblog.dto.response.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ControllerAdviceClient {
    @ExceptionHandler(EntradaBlogDuplicadaException.class)
    public ResponseEntity<ErrorDTO> EntradaBlogDuplicadaException(Exception e){
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setMensaje("El id ya se encuentra registrado en base de datos.Favor de validar");
        errorDTO.setEstatus(false);
        return new ResponseEntity<ErrorDTO>(errorDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EntradaBlogNoEncontradaException.class)
    public ResponseEntity<ErrorDTO> EntradaBlogNoEncontradaException(Exception e){
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setMensaje("la entrada de blog,que buscaste,No existe.");
        errorDTO.setEstatus(false);
        return new ResponseEntity<ErrorDTO>(errorDTO, HttpStatus.NOT_FOUND);
    }
}
