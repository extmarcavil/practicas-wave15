package com.example.starwars.exception;

public class BadQueryException extends RuntimeException {
    public BadQueryException(String message) {
        super(message);
    }
}
