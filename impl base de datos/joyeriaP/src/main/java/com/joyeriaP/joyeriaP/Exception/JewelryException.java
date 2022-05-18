package com.joyeriaP.joyeriaP.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class JewelryException extends RuntimeException {

    public JewelryException(String message) {
        super(message);
    }
}
