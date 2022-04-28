package com.be.java.hisp.w156.be.java.hisp.w156.vitale.exception;

public class UserNotFollowedException extends RuntimeException {

    public UserNotFollowedException(Integer userId, Integer userToUnfollowId) {
        super("The user " + userId + " wasn't following user " + userToUnfollowId);
    }
}
