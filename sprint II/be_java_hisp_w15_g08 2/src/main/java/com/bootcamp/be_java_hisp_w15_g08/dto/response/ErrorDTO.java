package com.bootcamp.be_java_hisp_w15_g08.dto.response;

import lombok.*;

import java.util.HashMap;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ErrorDTO {
    private String name;
    private String descripcion;
    private HashMap<String, List<String>> errors;

    public ErrorDTO(String name, HashMap<String, List<String>> errors) {
        this.name = name;
        this.errors = errors;
    }

    public ErrorDTO(String name, String descripcion) {
        this.name = name;
        this.descripcion = descripcion;
    }
}