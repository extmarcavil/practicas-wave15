package com.be.java.hisp.w156.be.java.hisp.w156.vitale.exception;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(Integer id) {
        super("The user with ID: " + id + " wasn't found");
    }

    public UserNotFoundException(String message) {
        super(message);
    }

}
