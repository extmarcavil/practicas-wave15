package com.calculadoradecalorias.calculadoradecalorias.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "El plato buscado no se encuentra en la base de datos")
public class NotFoudFood extends RuntimeException {
    public NotFoudFood(String message) {
        super(message);
    }
}
