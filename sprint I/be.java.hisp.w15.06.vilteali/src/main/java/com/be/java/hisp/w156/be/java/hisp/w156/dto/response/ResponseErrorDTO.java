package com.be.java.hisp.w156.be.java.hisp.w156.dto.response;

import lombok.Getter;

import java.time.Instant;

@Getter
public class ResponseErrorDTO {

    private final String message;
    private final Instant timestamp;

    public ResponseErrorDTO(String message, Instant timestamp) {
        this.message = message;
        this.timestamp = timestamp;
    }

    public static ResponseErrorDTO from(String message) {
        return new ResponseErrorDTO(message, Instant.now());
    }
}
