package com.meli.obtenerdiploma.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomException {
    private String message;
    private String description;

    public CustomException() {
    }

    public CustomException(String message, String description) {
        this.message = message;
        this.description = description;
    }
}

