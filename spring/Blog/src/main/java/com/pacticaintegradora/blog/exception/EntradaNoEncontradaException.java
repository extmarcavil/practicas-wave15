package com.pacticaintegradora.blog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No existe el blog")
public class EntradaNoEncontradaException extends RuntimeException {

    public EntradaNoEncontradaException() {
    }

    public EntradaNoEncontradaException(String message) {
        super(message);
    }
}
