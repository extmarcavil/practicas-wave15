package com.mercadolibre.fp_be_java_hisp_w15_g06.exceptions;

public class InvalidWarehouseException extends RuntimeException{

    public InvalidWarehouseException(Long id) {
        super("El warehouse con ID: " + id + " no fue encontrado.");
    }

}
