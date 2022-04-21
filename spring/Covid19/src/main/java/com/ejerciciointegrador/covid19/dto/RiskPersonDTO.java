package com.ejerciciointegrador.covid19.dto;

public class RiskPersonDTO {

    private String fullName;
    private int age;
    private SymptomDTO symptom;

    public RiskPersonDTO(String fullName, int age, SymptomDTO symptom) {
        this.fullName = fullName;
        this.age = age;
        this.symptom = symptom;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public SymptomDTO getSymptom() {
        return symptom;
    }

    public void setSymptom(SymptomDTO symptom) {
        this.symptom = symptom;
    }
}
