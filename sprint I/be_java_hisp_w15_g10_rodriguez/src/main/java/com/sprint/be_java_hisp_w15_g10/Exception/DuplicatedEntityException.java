package com.sprint.be_java_hisp_w15_g10.Exception;

public class DuplicatedEntityException extends RuntimeException{
    public DuplicatedEntityException(String message) {
        super(message);
    }
}
