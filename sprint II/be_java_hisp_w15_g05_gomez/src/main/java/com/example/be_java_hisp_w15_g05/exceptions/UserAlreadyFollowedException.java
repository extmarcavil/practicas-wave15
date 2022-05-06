package com.example.be_java_hisp_w15_g05.exceptions;

public class UserAlreadyFollowedException extends RuntimeException {

    public UserAlreadyFollowedException(String message) {
        super(message);
    }
}
