package com.mercadolibre.fp_be_java_hisp_w15_g05.exceptions;

import org.springframework.http.HttpStatus;

public class ProductOutOfStockException extends ApiException{
    public ProductOutOfStockException(String description) {
        super("not_found", description, HttpStatus.NOT_FOUND.value());
    }
}
