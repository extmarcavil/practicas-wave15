package com.mercadolibre.covid.model;

public class Symptom {

    private final String code;
    private final String name;
    private final int levelOfSeverity;

    public Symptom(String code, String name, int levelOfSeverity) {
        this.code = code;
        this.name = name;
        this.levelOfSeverity = levelOfSeverity;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getLevelOfSeverity() {
        return levelOfSeverity;
    }

    @Override
    public String toString() {
        return "Symptom{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", levelOfSeverity=" + levelOfSeverity +
                '}';
    }
}
