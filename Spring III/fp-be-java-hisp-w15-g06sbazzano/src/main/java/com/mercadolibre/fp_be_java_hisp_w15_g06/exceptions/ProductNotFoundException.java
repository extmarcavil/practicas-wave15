package com.mercadolibre.fp_be_java_hisp_w15_g06.exceptions;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(Long idNoExists) {
        super(String.format("Producto con ID: %s no existe.", idNoExists));
    }
}
