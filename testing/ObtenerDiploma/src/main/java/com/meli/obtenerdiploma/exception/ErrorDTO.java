package com.meli.obtenerdiploma.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;

public class ErrorDTO {

        String name;
        String message;
        List<String> listErrors;

        HashMap<String, List<String>> errors;

    public ErrorDTO ( String name, String message ) {
        this.name    = name;
        this.message = message;
    }

    public ErrorDTO ( String name, List<String> listErrors ) {
        this.name       = name;
        this.listErrors = listErrors;
    }

    public ErrorDTO ( String name, HashMap<String, List<String>> errors ) {
        this.name         = name;
        this.errors       = errors;
    }
}
