package com.be.java.hisp.w156.be.java.hisp.w156.exception;

public class UserAlreadyFollowsTheUserException extends RuntimeException {

    public UserAlreadyFollowsTheUserException(Integer id, Integer userToFollowId) {
        super("The user " + id + " was already following user " + userToFollowId);
    }
}
