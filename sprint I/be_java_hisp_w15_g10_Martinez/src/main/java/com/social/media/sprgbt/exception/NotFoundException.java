package com.social.media.sprgbt.exception;

public class NotFoundException extends RuntimeException {


    /**
     * Excepxion lanzada cuando un usuario no existe en BD.
     *
     * @param message
     */
    public NotFoundException(String message) {
        super(message);
    }
}
