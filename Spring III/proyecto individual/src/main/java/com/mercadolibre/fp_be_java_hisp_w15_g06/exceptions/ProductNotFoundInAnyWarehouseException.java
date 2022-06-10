package com.mercadolibre.fp_be_java_hisp_w15_g06.exceptions;

public class ProductNotFoundInAnyWarehouseException extends RuntimeException {

    public ProductNotFoundInAnyWarehouseException(Long idNoExists) {
        super(String.format("Producto con ID: %s no existe en ningún warehouse.", idNoExists));
    }
}
