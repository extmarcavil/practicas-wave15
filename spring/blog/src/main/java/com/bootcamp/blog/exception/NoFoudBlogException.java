package com.bootcamp.blog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "El id ingresado no se encontro en la base de datos")
public class NoFoudBlogException extends RuntimeException {
    public NoFoudBlogException(String mensaje) {
        super(mensaje);
    }
}
