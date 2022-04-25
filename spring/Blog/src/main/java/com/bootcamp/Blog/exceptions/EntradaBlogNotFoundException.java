package com.bootcamp.Blog.exceptions;

public class EntradaBlogNotFoundException extends RuntimeException {

    public EntradaBlogNotFoundException(String message) {
        super(message);
    }

    public EntradaBlogNotFoundException() {
    }
}
