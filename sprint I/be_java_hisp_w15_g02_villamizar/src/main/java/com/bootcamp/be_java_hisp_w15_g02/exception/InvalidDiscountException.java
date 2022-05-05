package com.bootcamp.be_java_hisp_w15_g02.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "El valor del descuento no es valido")
public class InvalidDiscountException extends RuntimeException {
    public InvalidDiscountException() {
    }

    public InvalidDiscountException(String message) {
        super(message);
    }
}
