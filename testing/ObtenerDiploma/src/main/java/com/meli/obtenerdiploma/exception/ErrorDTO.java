package com.meli.obtenerdiploma.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//si hay un campo que queda vacio porque no se usa, se ignora en la respuesta
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ErrorDTO {
    private String name;
    private String message;
    private HashMap<String, List<String>> errors;

    public ErrorDTO(String name, String message) {
        this.name = name;
        this.message = message;
    }

    public ErrorDTO(String name, HashMap<String, List<String>> errors) {
        this.name = name;
        this.errors = errors;
    }
}
