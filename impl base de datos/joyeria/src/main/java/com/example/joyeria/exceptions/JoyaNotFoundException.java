package com.example.joyeria.exceptions;

public class JoyaNotFoundException extends RuntimeException {
    public JoyaNotFoundException() {
    }

    public JoyaNotFoundException(String message) {
        super(message);
    }
}
