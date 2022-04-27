package com.youtuber.spring.exepciones;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus()
public class BlogExepciones extends RuntimeException{
    public BlogExepciones(String message) {
        super(message);
    }
}
