package com.be.java.hisp.w156.be.java.hisp.w156.exception;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(Integer id) {
        super("El usuario con ID: " + id + " no fue encontrado");
    }

}
