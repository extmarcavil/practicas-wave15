package com.be.java.hisp.w156.be.java.hisp.w156.exception;

public class DiscountLessThanZeroException extends RuntimeException {

    public DiscountLessThanZeroException(Double discount) {
        super(String.format("The discount %s cannot be less than or equal to 0", discount));
    }
}
