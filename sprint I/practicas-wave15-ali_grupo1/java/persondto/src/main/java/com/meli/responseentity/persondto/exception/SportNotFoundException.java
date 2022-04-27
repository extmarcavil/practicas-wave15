package com.meli.responseentity.persondto.exception;

public class SportNotFoundException extends RuntimeException {

    public SportNotFoundException(String name) {
        super(String.format("Sport \"%s\" wasn't found", name));
    }

}
