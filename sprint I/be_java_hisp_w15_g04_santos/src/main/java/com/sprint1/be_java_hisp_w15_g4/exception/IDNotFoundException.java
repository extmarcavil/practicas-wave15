package com.sprint1.be_java_hisp_w15_g4.exception;


public class IDNotFoundException extends RuntimeException {

    public IDNotFoundException(int id) {
        super("No se ha encontrado el usuario: " + id);
    }
}
