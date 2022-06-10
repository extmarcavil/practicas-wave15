package com.mercadolibre.fp_be_java_hisp_w15_g06.exceptions;

public class InvalidBatchException extends RuntimeException{

    public InvalidBatchException(Long id) {
        super("El batch con Id " + id + " no fue encontrado.");
    }

}