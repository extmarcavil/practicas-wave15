package com.example.be_java_hisp_w15_g05.exceptions;

public class InvalidPriceException extends RuntimeException{

    public InvalidPriceException() {
    }

    public InvalidPriceException(String message) {
        super(message);
    }
}
