package com.be.java.hisp.w156.be.java.hisp.w156.exception;

public class PriceLessThanZeroException extends RuntimeException {

    public PriceLessThanZeroException(Double price) {
        super(String.format("The price %s cannot be less than or equal to 0", price));
    }
}
