package com.social.media.sprgbt.exception;

public class ExistingException extends RuntimeException {


    /**
     * excepcion lanzada cuando el usuario ya existe.
     *
     * @param message
     */
    public ExistingException(String message) {
        super(message);
    }

}
