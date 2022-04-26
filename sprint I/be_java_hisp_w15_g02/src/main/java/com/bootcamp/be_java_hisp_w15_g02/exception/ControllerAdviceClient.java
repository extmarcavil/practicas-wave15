package com.bootcamp.be_java_hisp_w15_g02.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdviceClient{

    @ExceptionHandler(CantFollowException.class)
    public ResponseEntity<?> cantFollowHandler() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error en proceso de seguir");
    }
}
