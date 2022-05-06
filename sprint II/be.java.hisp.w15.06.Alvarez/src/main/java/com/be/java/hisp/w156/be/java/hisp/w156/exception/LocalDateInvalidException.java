package com.be.java.hisp.w156.be.java.hisp.w156.exception;

public class LocalDateInvalidException extends RuntimeException {

    public LocalDateInvalidException() {
        super("La fecha no puede estar vacía o ser diferente al formato 'dd-MM-yyyy'");
    }
}
