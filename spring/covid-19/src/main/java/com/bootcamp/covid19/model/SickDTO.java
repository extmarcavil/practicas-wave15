package com.bootcamp.covid19.model;

import java.io.Serializable;
import java.util.List;

public class SickDTO implements Serializable {
    private String id;
    private String fullName;
    private int age;
    private List<String> listSymptom;

    public SickDTO() {
    }

    public SickDTO(String id, String fullName, int age, List<String> nameSymptom) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
        this.listSymptom = nameSymptom;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
