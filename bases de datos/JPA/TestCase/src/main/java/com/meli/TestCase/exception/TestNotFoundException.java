package com.meli.TestCase.exception;
public class TestNotFoundException extends RuntimeException{

    public TestNotFoundException() {
    }

    public TestNotFoundException(String message) {
        super(message);
    }
}
