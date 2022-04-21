package com.example.covid.model;

public class Sintoma {
    private String code;
    private String name;
    private int severityLvl;

    public Sintoma(String code, String name, int severityLvl) {
        this.code = code;
        this.name = name;
        this.severityLvl = severityLvl;
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

    public int getSeverityLvl() {
        return severityLvl;
    }

    public void setSeverityLvl(int severityLvl) {
        this.severityLvl = severityLvl;
    }
}
