package com.sprint1.be_java_hisp_w15_g4.exception;

public class NotFoundFollowingException extends RuntimeException{
    public NotFoundFollowingException(int userID, int userIDToFollow){
        super("El Usuario "+userID+" no puede seguir al Usuario "+userIDToFollow+ " (No te podes seguir a vos mismo!)");
    }
}
