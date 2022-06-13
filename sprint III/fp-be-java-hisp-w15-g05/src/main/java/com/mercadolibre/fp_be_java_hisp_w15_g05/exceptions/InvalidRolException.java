package com.mercadolibre.fp_be_java_hisp_w15_g05.exceptions;

import org.springframework.http.HttpStatus;

public class InvalidRolException extends ApiException {

    public InvalidRolException() {
        super("invalid_rol", "El usuario no tiene permisos para acceder", HttpStatus.UNAUTHORIZED.value());
    }
}
