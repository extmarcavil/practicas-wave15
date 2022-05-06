package com.sprint1.be_java_hisp_w15_g03_acosta.exception;

public class OrderInvalidException extends RuntimeException{

    public OrderInvalidException() {
    }

    public OrderInvalidException(String message) {
        super(message);
    }
}
