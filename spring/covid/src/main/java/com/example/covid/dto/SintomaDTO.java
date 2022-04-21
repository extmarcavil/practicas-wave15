package com.example.covid.dto;

import java.io.Serializable;

public class SintomaDTO implements Serializable {
    private String name;
    private int severityLvl;

    public SintomaDTO(String name, int severityLvl) {
        this.name = name;
        this.severityLvl = severityLvl;
    }

    public String getName() {
        return name;
    }

    public int getSeverityLvl() {
        return severityLvl;
    }
}
