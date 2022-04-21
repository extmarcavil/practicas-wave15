package com.bootcamp.covid19.model;

public class Symptom {
    private String code;
    private String name;
    private Integer severity;

    public Symptom() {
    }

    public Symptom(String code, String name, Integer severity) {
        this.code = code;
        this.name = name;
        this.severity = severity;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSeverity() {
        return severity;
    }

    public void setSeverity(Integer severity) {
        this.severity = severity;
    }
}
