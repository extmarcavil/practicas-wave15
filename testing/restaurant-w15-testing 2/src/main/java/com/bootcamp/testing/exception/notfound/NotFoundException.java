package com.bootcamp.testing.exception.notfound;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class NotFoundException extends RuntimeException{
    private final String exception;
    private final HttpStatus status;

    public NotFoundException(String message, String exception){
        super(message);
        status = HttpStatus.I_AM_A_TEAPOT;
        this.exception = exception;
    }
}
