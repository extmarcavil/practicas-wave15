package com.sprint1.be_java_hisp_w15_g4.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No se encontro.")
public class IDNotFoundException extends RuntimeException {
    public IDNotFoundException(String s) {
        super(s);
    }
}
