package com.bootcamp.testing.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter @Setter
public class ExceptionDTO {
    private String exception;
    private HttpStatus status;
    private String messageException;
}
