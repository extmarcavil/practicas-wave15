package com.ejerciciointegrador.covid19.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Symptom {

    private int code;
    private String name;
    private String severityLevel;

    public Symptom(int code, String name, String severityLevel) {
        this.code = code;
        this.name = name;
        this.severityLevel = severityLevel;
    }
}
