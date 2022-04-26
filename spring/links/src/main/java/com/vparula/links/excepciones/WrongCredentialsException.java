package com.vparula.links.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.ALREADY_REPORTED,reason = "Ya existe")
public class WrongCredentialsException extends RuntimeException{
    public WrongCredentialsException (String mensaje){
        super(mensaje);
    }
}
