package com.youtuber.exception.dto;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ResponseExceptionDTO {

    private final String message;
    private final HttpStatus httpStatus;
    private final Integer httpStatusCode;


    public ResponseExceptionDTO(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.httpStatusCode = httpStatus.value();
    }
}