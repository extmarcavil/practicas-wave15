package com.example.be_java_hisp_w15_g07.exception;

public class BadRequestException extends RuntimeException {
    public BadRequestException(){}
    public BadRequestException(String s) {
        super(s);
    }
}
