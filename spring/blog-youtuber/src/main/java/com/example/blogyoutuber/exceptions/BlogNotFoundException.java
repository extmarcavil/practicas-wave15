package com.example.blogyoutuber.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No se encontro en el Blog!")
public class BlogNotFoundException extends RuntimeException {

    public BlogNotFoundException(String message){
        super(message);
    }


}
