package com.sprint1.be_java_hisp_w15_g03_acosta.exception;

public class ProductDuplicatedException extends RuntimeException{
    public ProductDuplicatedException() {
    }

    public ProductDuplicatedException(String message) {
        super(message);
    }
}
