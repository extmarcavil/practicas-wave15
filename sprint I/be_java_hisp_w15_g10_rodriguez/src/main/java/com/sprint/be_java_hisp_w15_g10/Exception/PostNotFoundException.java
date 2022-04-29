package com.sprint.be_java_hisp_w15_g10.Exception;

public class PostNotFoundException extends RuntimeException{
    public PostNotFoundException(String message) {
        super(message);
    }
}
