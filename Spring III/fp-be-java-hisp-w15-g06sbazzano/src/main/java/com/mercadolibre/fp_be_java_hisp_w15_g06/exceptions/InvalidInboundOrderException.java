package com.mercadolibre.fp_be_java_hisp_w15_g06.exceptions;

public class InvalidInboundOrderException extends RuntimeException{

    public InvalidInboundOrderException(Long id) {
        super("El inbound con Id " + id + " no fue encontrado.");
    }

}