package com.be.java.hisp.w156.be.java.hisp.w156.exception;

public class OrderNotFoundException extends RuntimeException{
    public OrderNotFoundException(String order){
        super(String.format("This is not an acceptable order : %s ", order) );
    }
}
