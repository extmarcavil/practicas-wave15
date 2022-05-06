package com.example.be_java_hisp_w15_g07_ravelli.dto.response;

import lombok.*;

import java.util.HashMap;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class ErrorDTO {
    private String name;
    private String description;
    private HashMap<String, List<String>> errors;

    public ErrorDTO(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public ErrorDTO(String name, HashMap<String, List<String>> errors) {
        this.name = name;
        this.errors = errors;
    }
}
