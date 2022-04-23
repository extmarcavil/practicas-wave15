package com.bootcamp.Covid19.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Symptom {

    private int symptom_code;
    private String name, severity;

    public Symptom(int symptom_code, String name, String severity) {
        this.symptom_code = symptom_code;
        this.name = name;
        this.severity = severity;
    }

}
