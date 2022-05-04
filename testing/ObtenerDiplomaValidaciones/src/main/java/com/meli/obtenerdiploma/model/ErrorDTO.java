package com.meli.obtenerdiploma.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ErrorDTO {
    private String name;
    private String description;

    private HashMap<String, List<String>> errors;

    public ErrorDTO(String name, HashMap<String, List<String>> errors) {
        this.name = name;
        this.errors = errors;
    }

    public ErrorDTO(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
