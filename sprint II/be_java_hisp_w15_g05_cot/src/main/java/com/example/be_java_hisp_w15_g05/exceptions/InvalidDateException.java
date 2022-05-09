package com.example.be_java_hisp_w15_g05.exceptions;

public class InvalidDateException extends  RuntimeException{

    public InvalidDateException() {
    }

    public InvalidDateException(String message) {
        super(message);
    }
}
