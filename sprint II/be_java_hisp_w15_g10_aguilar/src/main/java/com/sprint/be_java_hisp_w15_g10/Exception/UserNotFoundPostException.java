package com.sprint.be_java_hisp_w15_g10.Exception;

public class UserNotFoundPostException extends RuntimeException{
    public UserNotFoundPostException(String message) {
        super(message);
    }
}
