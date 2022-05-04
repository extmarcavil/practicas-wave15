package com.spring.ejerciciocovid19.model;

public class Sintoma {
    private String codigo;
    private String name;
    private int severityLevel;

    public Sintoma(String codigo, String name, int severityLevel) {
        this.codigo = codigo;
        this.name = name;
        this.severityLevel = severityLevel;
    }
}
