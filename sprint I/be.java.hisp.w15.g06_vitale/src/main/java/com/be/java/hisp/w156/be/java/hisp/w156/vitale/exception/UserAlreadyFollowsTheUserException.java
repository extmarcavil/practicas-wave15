package com.be.java.hisp.w156.be.java.hisp.w156.vitale.exception;

public class UserAlreadyFollowsTheUserException extends RuntimeException {

    public UserAlreadyFollowsTheUserException(Integer id, Integer userToFollowId) {
        super("The user " + id + " already follows the user " + userToFollowId);
    }
}
