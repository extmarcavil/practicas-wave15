package com.sprint1.be_java_hisp_w15_g4.exception;

public class AlreadyFollowingException extends RuntimeException {

    public AlreadyFollowingException(Integer userId, Integer userIdToFollow) {
        super(String.format("El usuario %d ya sigue al usuario %d",userId,userIdToFollow));
    }
}
