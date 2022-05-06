package com.sprint2.be_java_hisp_w15_g4.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class IDNotFoundException extends RuntimeException {
    public IDNotFoundException(int id) {
        super("No se ha encontrado el usuario: " + id);
    }
}
