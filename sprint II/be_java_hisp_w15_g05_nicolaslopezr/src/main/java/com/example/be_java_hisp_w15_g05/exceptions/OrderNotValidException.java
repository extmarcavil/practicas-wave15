package com.example.be_java_hisp_w15_g05.exceptions;

public class OrderNotValidException extends RuntimeException{
    public OrderNotValidException(String message) {
        super(message);
    }
}
