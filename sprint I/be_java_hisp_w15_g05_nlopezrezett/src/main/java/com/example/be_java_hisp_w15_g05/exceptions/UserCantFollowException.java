package com.example.be_java_hisp_w15_g05.exceptions;

public class UserCantFollowException extends RuntimeException {
    public UserCantFollowException(String message) {
        super(message);
    }
}
