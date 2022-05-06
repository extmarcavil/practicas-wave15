package com.example.be_java_hisp_w15_g05.exceptions;

public class UserCannotFollowHimself extends RuntimeException {

    public UserCannotFollowHimself(String message) {
        super(message);
    }
}
