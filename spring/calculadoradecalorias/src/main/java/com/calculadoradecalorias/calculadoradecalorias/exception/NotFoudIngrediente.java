package com.calculadoradecalorias.calculadoradecalorias.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "El ingrediente no se encuentra en la base de datos")
public class NotFoudIngrediente extends RuntimeException {
    public NotFoudIngrediente(String message) {
        super(message);
    }
}
