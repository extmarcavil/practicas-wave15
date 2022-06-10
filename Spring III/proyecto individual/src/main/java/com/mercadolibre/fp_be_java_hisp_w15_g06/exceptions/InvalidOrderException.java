package com.mercadolibre.fp_be_java_hisp_w15_g06.exceptions;

public class InvalidOrderException extends RuntimeException{
    public InvalidOrderException() {
        super("El tipo de ordenamiento no es valido.");
    }
}
