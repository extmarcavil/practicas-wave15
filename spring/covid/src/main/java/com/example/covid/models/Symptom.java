package com.example.covid.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Symptom {
    private int cod;
    private String name;
    private int severityLevel;

    public Symptom(int cod, String name, int severityLevel) {
        this.cod = cod;
        this.name = name;
        this.severityLevel = severityLevel;
    }
}
