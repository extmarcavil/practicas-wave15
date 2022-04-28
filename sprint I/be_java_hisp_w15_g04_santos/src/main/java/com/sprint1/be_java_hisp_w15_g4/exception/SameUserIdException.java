package com.sprint1.be_java_hisp_w15_g4.exception;

public class SameUserIdException extends RuntimeException {

    public SameUserIdException(int userId) {
        super("El usuario #" + userId + " no puede seguirse a si mismo");
    }
}
