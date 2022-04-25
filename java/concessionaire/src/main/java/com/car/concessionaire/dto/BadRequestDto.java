package com.car.concessionaire.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.Instant;
import java.util.List;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class BadRequestDto {

    private final String message;
    private final List<FieldErrorDto> fieldErrors;
    private final Instant timestamp;

    public static BadRequestDto from(String message, List<FieldErrorDto> fieldErrors) {
        return new BadRequestDto(message, fieldErrors, Instant.now());
    }

}
