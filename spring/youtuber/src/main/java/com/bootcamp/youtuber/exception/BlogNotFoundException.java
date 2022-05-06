package com.bootcamp.youtuber.exception;

public class BlogNotFoundException extends RuntimeException {

    /**
     * Constructor
     */
    public BlogNotFoundException() {
    }

    public BlogNotFoundException(String message) {
        super(message);
    }
}
