package com.example.linktracker.exceptions;

public class InvalidURLException extends RuntimeException {
    public InvalidURLException() {
    }

    public InvalidURLException(String message) {
        super(message);
    }
}
