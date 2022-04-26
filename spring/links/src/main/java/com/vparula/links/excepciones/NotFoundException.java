package com.vparula.links.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(value= HttpStatus.ALREADY_REPORTED,reason = "Ya existe")
public class NotFoundException extends RuntimeException{

   public NotFoundException(String mensaje){
            super(mensaje);
        }



}
