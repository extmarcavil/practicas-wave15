package com.sprint1.be_java_hisp_w15_g4.exception;

public class EqualsIDException extends RuntimeException {
    public EqualsIDException(int id) {
        super("Los id deben ser diferentes: " + id);
    }
}
