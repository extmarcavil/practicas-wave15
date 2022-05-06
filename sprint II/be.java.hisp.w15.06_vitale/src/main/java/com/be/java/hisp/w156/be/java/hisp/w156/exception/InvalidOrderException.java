package com.be.java.hisp.w156.be.java.hisp.w156.exception;

public class InvalidOrderException extends RuntimeException {

    public InvalidOrderException() {
        super("El tipo de ordenamiento no es valido.");
    }
}
