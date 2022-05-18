package com.Spring.LinkTracker.exception;

public class IdNotFound extends RuntimeException{

    public IdNotFound(int id) {
        super("No se ha encontrado el link: " + id);
    }

}
