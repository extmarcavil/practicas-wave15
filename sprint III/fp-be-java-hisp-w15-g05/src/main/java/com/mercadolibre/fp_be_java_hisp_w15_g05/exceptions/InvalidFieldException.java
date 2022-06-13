package com.mercadolibre.fp_be_java_hisp_w15_g05.exceptions;

public class InvalidFieldException extends ApiException {

    public InvalidFieldException(String message) {
        super("invalid_field", message, 404);
    }
}
