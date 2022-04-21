package com.example.ejerciciocovid.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SymptomDTO {
    private String name;
    private String severityLevel;

    public SymptomDTO(String name, String severityLevel) {
        this.name = name;
        this.severityLevel = severityLevel;
    }
}
