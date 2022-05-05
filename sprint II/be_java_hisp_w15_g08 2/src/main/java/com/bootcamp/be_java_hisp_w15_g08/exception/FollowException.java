package com.bootcamp.be_java_hisp_w15_g08.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Follow Error")
public class FollowException extends RuntimeException {
    public FollowException(String message) {
        super(message);
    }


}