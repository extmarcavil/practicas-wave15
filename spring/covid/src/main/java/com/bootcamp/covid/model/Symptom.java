package com.bootcamp.covid.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Symptom {
    private String code;
    private String name;
    private String severityLevel;

    public Symptom(String code, String name, String severityLevel) {
        this.code = code;
        this.name = name;
        this.severityLevel = severityLevel;
    }
}

