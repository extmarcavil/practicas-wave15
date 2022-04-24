package com.bootcamp.blog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.EXPECTATION_FAILED, reason = "El id ingresado ya existe en la base de datos")
public class ExistingBlockEntranceException extends RuntimeException{
    public ExistingBlockEntranceException(String mensaje) {
        super(mensaje);
    }

}
