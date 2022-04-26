package com.vparula.links.excepciones;

import com.vparula.links.dtos.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdviceCli {
    @ExceptionHandler(InvalidatedLinkException.class)
    public ResponseEntity<ErrorDTO> invalidatedLinkException(InvalidatedLinkException invalidate){
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setName("Link invalido");
        errorDTO.setDescription(invalidate.getMessage());
        return new ResponseEntity<ErrorDTO>(errorDTO, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorDTO> notFoundException(NotFoundException invalidate){
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setName("Link inexistente");
        errorDTO.setDescription(invalidate.getMessage());
        return new ResponseEntity<ErrorDTO>(errorDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(WrongCredentialsException.class)
    public ResponseEntity<ErrorDTO> wrongCredentialsException(WrongCredentialsException invalidate){
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setName("Credenciales de acceso incorrectas");
        errorDTO.setDescription(invalidate.getMessage());
        return new ResponseEntity<ErrorDTO>(errorDTO, HttpStatus.FORBIDDEN);
    }

}
