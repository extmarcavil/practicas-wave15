package com.example.blogyoutuber.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BlogNotFoundException extends RuntimeException {

    public BlogNotFoundException(String message){
        super(message);
    }
}
