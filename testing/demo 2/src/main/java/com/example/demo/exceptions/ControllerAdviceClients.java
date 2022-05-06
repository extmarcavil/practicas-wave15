package com.example.demo.exceptions;

import com.example.demo.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
public class ControllerAdviceClients {
/*
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFoundHandler(Exception e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
*/
/*
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorDTO> notFoundHandler(NotFoundException notFoundException){
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setName("Not Found");
        errorDTO.setDescription(notFoundException.getMessage());
        return new ResponseEntity<ErrorDTO>(errorDTO,HttpStatus.ALREADY_REPORTED);
    }
*/
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ErrorDTO> divisionPorZero(ArithmeticException e){
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setName("Dividiste un numero entero por cero");
        errorDTO.setDescription(e.getMessage());
        return new ResponseEntity<ErrorDTO>(errorDTO,HttpStatus.BAD_REQUEST);
    }

}
