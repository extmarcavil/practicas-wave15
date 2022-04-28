package com.be.java.hisp.w156.be.java.hisp.w156.vitale.exception;

public class TheUserWasNotFoundException extends RuntimeException {

    public TheUserWasNotFoundException(Integer userId, Integer userToUnfollowId) {
        super("The user " + userId + " wasn't following user " + userToUnfollowId);
    }
}
