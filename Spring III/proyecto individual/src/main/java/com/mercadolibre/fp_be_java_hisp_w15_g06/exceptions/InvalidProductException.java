package com.mercadolibre.fp_be_java_hisp_w15_g06.exceptions;

public class InvalidProductException extends RuntimeException{

    public InvalidProductException(Long id) {
        super("El producto con ID: " + id + " no fue encontrado.");
    }

}
