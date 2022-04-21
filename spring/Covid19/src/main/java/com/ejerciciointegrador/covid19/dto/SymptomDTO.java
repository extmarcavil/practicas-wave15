package com.ejerciciointegrador.covid19.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SymptomDTO {

    private String severityLevel;

    public SymptomDTO(String severityLevel) {
        this.severityLevel = severityLevel;
    }
}
