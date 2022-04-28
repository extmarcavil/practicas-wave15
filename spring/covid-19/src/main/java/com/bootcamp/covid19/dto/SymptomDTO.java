package com.bootcamp.covid19.dto;

import com.bootcamp.covid19.model.Symptom;

public class SymptomDTO {
    private String code;
    private String name;
    private Integer severity;


    public SymptomDTO() {
    }

    public SymptomDTO(Symptom symptom) {
        this.code = symptom.getCode();
        this.name = symptom.getName();
        this.severity = symptom.getSeverity();
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
