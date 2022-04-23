package com.pacticaintegradora.blog.exception;

public class EntradaExistenteException extends RuntimeException {

    public EntradaExistenteException() {
    }

    public EntradaExistenteException(String message) {
        super(message);
    }
}
