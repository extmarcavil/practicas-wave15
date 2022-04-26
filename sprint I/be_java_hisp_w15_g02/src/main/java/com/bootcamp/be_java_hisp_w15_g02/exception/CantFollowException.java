package com.bootcamp.be_java_hisp_w15_g02.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Usuario no puede ser seguido")
public class CantFollowException extends RuntimeException {

    public CantFollowException() {
    }

    public CantFollowException(String message) {
        super(message);
    }
}
