package com.bootcamp.be_java_hisp_w15_g02.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "No puede seguirse así mismo.")
public class FollowYourselfException extends RuntimeException {

    public FollowYourselfException() {
    }

    public FollowYourselfException(String message) {
        super(message);
    }
}
