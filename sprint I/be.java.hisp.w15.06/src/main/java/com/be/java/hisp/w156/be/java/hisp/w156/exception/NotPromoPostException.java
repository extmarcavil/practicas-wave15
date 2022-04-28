package com.be.java.hisp.w156.be.java.hisp.w156.exception;

public class NotPromoPostException extends RuntimeException{

    public NotPromoPostException() {
        super("This is not a promotional post, please enter a promotional price");
    }
}
