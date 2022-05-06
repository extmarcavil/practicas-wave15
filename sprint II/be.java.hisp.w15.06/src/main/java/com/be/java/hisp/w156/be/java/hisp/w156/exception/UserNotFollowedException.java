package com.be.java.hisp.w156.be.java.hisp.w156.exception;

public class UserNotFollowedException extends RuntimeException {

    public UserNotFollowedException(Integer userId, Integer userToUnfollowId) {
        super("El usuario " + userId + " no seguía al usuario " + userToUnfollowId);
    }
}
