package com.mercadolibre.fp_be_java_hisp_w15_g06.exceptions;

public class ProductsNotFoundException extends RuntimeException {

    public ProductsNotFoundException() {
        super("No se encontraron productos");
    }
}
