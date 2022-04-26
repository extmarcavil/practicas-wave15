package com.sprint1.be_java_hisp_w15_g03.exception;

public class PersonNotFound extends RuntimeException {
    public PersonNotFound() {
    }

    public PersonNotFound(String message) {
        super(message);
    }
}
