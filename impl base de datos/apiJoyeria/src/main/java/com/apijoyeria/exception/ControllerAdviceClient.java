package com.apijoyeria.exception;

import com.apijoyeria.dto.response.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdviceClient {

    @ExceptionHandler(JoyaNotFoundException.class)
    public ResponseEntity<ErrorDTO> joyaNotFoundHandler() {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setMessage("La joya no existe.");
        errorDTO.setStatus(HttpStatus.BAD_REQUEST.toString());
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }
}
