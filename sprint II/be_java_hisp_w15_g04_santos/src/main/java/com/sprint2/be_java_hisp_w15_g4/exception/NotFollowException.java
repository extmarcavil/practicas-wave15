package com.sprint2.be_java_hisp_w15_g4.exception;

public class NotFollowException extends RuntimeException{
    public NotFollowException(int id) {
        super("No estas siguiendo al usuario: " + id);
    }

}
