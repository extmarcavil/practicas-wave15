package com.springp2pg.covid19.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Symptom {

    private int code;
    private String name;
    private String severity_level;


    public Symptom() {
    }

    public Symptom(int code, String name, String severity_level) {
        this.code = code;
        this.name = name;
        this.severity_level = severity_level;
    }
}
