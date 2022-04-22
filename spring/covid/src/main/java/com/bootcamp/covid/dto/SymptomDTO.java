package com.bootcamp.covid.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SymptomDTO {
    String code;
    String name;
    String severityLevel;

    public SymptomDTO ( String code, String name, String severityLevel ) {
        this.code          = code;
        this.name          = name;
        this.severityLevel = severityLevel;
    }
}
