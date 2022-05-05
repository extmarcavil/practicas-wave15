package com.sprint1.be_java_hisp_w15_g03.exception;

public class OrderInvalidException extends RuntimeException{

    public OrderInvalidException() {
    }

    public OrderInvalidException(String message) {
        super(message);
    }
}
