package com.sprint1.be_java_hisp_w15_g4.exception;

public class IdEqualsException extends RuntimeException{
    public IdEqualsException() {
        super("Los usuarios a seguir deben ser diferentes");
    }
}
