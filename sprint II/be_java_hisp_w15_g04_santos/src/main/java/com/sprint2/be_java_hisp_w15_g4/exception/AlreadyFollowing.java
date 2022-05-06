package com.sprint2.be_java_hisp_w15_g4.exception;

public class AlreadyFollowing extends RuntimeException{
    public AlreadyFollowing(Integer userId,Integer userIdToFollow) {
        super(String.format("El usuario %d ya sigue al usuario %d",userId,userIdToFollow));
    }
}
