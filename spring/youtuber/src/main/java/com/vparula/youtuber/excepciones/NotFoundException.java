package com.vparula.youtuber.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(value= HttpStatus.NOT_FOUND,reason = "No existe entrada")
public class NotFoundException extends RuntimeException {
    public NotFoundException(String mensaje){
        super(mensaje);
    }

}
