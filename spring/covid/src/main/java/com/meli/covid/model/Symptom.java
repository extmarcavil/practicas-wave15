package com.meli.covid.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Symptom {
    private Number code;
    private String name;
    private String level_severity;

    public Symptom(Number code, String name, String level_severity) {
        this.code = code;
        this.name = name;
        this.level_severity = level_severity;
    }
}
