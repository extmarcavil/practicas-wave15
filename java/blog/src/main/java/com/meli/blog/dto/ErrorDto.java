package com.meli.blog.dto;

import com.meli.blog.exceptions.ApiException;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.Instant;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ErrorDto {

    private final String message;
    private final int errorCode;
    private final Instant timestamp;

    public static ErrorDto from(ApiException exception) {
        return new ErrorDto(exception.getMessage(), exception.getErrorCode(), Instant.now());
    }
}
