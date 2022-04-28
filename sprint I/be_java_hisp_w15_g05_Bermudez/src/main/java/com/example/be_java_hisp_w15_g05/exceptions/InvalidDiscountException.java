package com.example.be_java_hisp_w15_g05.exceptions;

public class InvalidDiscountException extends RuntimeException{

    public InvalidDiscountException() {
    }

    public InvalidDiscountException(String message) {
        super(message);
    }
}
