package com.bootcamp.covid.dto;

import com.bootcamp.covid.model.Symptom;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SymptomDTO {
    private String name;
    private String severityLevel;

    public SymptomDTO(Symptom symptom) {
        this.name = symptom.getName();
        this.severityLevel = symptom.getSeverityLevel();
    }
}
