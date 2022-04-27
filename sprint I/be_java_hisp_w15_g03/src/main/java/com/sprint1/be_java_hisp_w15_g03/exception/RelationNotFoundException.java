package com.sprint1.be_java_hisp_w15_g03.exception;

public class RelationNotFoundException extends RuntimeException {

    public RelationNotFoundException() {
    }

    public RelationNotFoundException(String message) {
        super(message);
    }
}
