package com.sprint1.be_java_hisp_w15_g03.exception;

public class RelationNotFound extends RuntimeException{
    public RelationNotFound() {
    }

    public RelationNotFound(String message) {
        super(message);
    }
}
