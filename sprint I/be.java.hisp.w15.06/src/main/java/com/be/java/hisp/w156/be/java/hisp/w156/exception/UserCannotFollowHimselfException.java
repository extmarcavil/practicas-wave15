package com.be.java.hisp.w156.be.java.hisp.w156.exception;

public class UserCannotFollowHimselfException extends RuntimeException {

    public UserCannotFollowHimselfException() {
        super("The user cannot follow himself");
    }
}
