package com.be.java.hisp.w156.be.java.hisp.w156.exception;

public class UserCantFollowHimselfException extends RuntimeException {

    public UserCantFollowHimselfException() {
        super("El usuario no puede seguirse a si mismo.");
    }
}
