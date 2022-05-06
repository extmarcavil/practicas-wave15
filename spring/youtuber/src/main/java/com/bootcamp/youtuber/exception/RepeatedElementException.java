package com.bootcamp.youtuber.exception;


public class RepeatedElementException extends RuntimeException {

    /**
     * Constructor
     */
    public RepeatedElementException() {
    }

    public RepeatedElementException(String message) {
        super(message);
    }
}
