package com.vparula.youtuber.excepciones;

import com.vparula.youtuber.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdviceClient {

    @ExceptionHandler(BlogExisteException.class)
    public ResponseEntity<ErrorDTO> blogExisteExceptionHandler(BlogExisteException blogExiste){
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setName("ID Already taken");
        errorDTO.setDescription(blogExiste.getMessage());
        return new ResponseEntity<ErrorDTO>(errorDTO, HttpStatus.ALREADY_REPORTED);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorDTO> notFoundHandler(NotFoundException notFound){
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setName("No se encontro entrada");
        errorDTO.setDescription(notFound.getMessage());
        return new ResponseEntity<ErrorDTO>(errorDTO, HttpStatus.NOT_FOUND);
    }
}
