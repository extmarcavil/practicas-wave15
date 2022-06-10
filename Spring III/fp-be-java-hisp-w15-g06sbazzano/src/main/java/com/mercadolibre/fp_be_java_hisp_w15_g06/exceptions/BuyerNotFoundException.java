package com.mercadolibre.fp_be_java_hisp_w15_g06.exceptions;

public class BuyerNotFoundException extends RuntimeException {

    public BuyerNotFoundException(Long id) {
        super(String.format("Buyer con ID: %s no existe.", id));
    }
}
