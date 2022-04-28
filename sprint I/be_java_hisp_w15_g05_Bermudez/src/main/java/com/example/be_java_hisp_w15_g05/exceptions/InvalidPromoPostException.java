package com.example.be_java_hisp_w15_g05.exceptions;

public class InvalidPromoPostException extends RuntimeException{

    public InvalidPromoPostException() {
    }

    public InvalidPromoPostException(String message) {
        super(message);
    }
}
