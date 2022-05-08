package com.social.media.sprgbt.exception;

public class OrderNotExistingException extends RuntimeException {

    /**
     * excepcion lanzada cuando el El orden alfabetico no es valido.
     *
     * @param message
     */
    public OrderNotExistingException(String message) {
        super(message);
    }
}


