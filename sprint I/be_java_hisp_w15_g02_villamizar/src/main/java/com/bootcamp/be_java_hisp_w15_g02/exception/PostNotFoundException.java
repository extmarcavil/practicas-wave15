package com.bootcamp.be_java_hisp_w15_g02.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Orden no valido")
public class PostNotFoundException extends RuntimeException{
    public PostNotFoundException(){

    }
    public PostNotFoundException(String message){
        super(message);
    }
}
