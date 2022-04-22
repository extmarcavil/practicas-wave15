package com.meli.blog.exceptions;

public abstract class ApiException extends RuntimeException {

    public ApiException(String message) {
        super(message);
    }

    public abstract int getErrorCode();
}
