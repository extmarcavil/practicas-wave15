package com.mercadolibre.fp_be_java_hisp_w15_g05.exceptions;


import org.springframework.http.HttpStatus;

public class ProductNotFoundException extends ApiException{
    public ProductNotFoundException(String message) {
        super("not_found",message, HttpStatus.NOT_FOUND.value());
    }
}
