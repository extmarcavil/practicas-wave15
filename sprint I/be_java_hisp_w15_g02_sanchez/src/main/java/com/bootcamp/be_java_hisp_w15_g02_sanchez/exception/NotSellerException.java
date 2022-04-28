package com.bootcamp.be_java_hisp_w15_g02_sanchez.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Usuario no puede ser seguido")
public class NotSellerException extends RuntimeException {

    public NotSellerException() {
    }

    public NotSellerException(String message) {
        super(message);
    }
}
