package com.mercadolibre.fp_be_java_hisp_w15_g05.exceptions;

public class OutOfSpaceException extends ApiException {

    public OutOfSpaceException(String message) {
        super("out_of_space", message, 404);
    }
}
