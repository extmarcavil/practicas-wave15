package com.bootcamp.covid19.dtos;

import java.io.Serializable;
import java.util.List;

public class PatientDTO implements Serializable {
    private String fullName;
    private int age;
    private List<String> listSymptom;

    public PatientDTO() {
    }

    public PatientDTO(String fullName, int age, List<String> nameSymptom) {
        this.fullName = fullName;
        this.age = age;
        this.listSymptom = nameSymptom;
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

    public List<String> getListSymptom() {
        return listSymptom;
    }

    public void setListSymptom(List<String> listSymptom) {
        this.listSymptom = listSymptom;
    }
}
