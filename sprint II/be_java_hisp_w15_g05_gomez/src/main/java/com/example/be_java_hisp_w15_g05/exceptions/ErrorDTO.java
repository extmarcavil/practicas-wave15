package com.example.be_java_hisp_w15_g05.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Getter
@Setter
public class ErrorDTO {
    String name;
    String message;

    List<String> listErrors;

    HashMap<String, List<String>> errors;
    public ErrorDTO ( String name, String message ) {
        this.name    = name;
        this.message = message;
    }

    public ErrorDTO ( String name, HashMap<String, List<String>> errors ) {
        this.name         = name;
        this.errors       = errors;
    }
}
