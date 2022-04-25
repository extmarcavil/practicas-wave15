package com.vparula.youtuber.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(value= HttpStatus.ALREADY_REPORTED,reason = "Ya existe")
public class BlogExisteException extends RuntimeException {
        public BlogExisteException(String mensaje){
            super(mensaje);
        }

}
