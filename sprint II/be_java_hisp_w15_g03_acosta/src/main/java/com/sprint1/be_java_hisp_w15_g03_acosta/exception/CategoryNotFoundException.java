package com.sprint1.be_java_hisp_w15_g03_acosta.exception;

public class CategoryNotFoundException extends RuntimeException{

    public CategoryNotFoundException() {
    }

    public CategoryNotFoundException(String message) {
        super(message);
    }
}
