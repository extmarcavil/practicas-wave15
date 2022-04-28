package com.bootcamp.covid19.model;

import java.util.List;

public class Person {
    private String id;
    private String name;
    private String lastName;
    private Integer age;
    private List<Symptom> listSymptom;

    public Person() {
    }

    public Person(String id, String name, String lastName, Integer age, List<Symptom> listSymptom) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.listSymptom = listSymptom;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Symptom> getListSymptom() {
        return listSymptom;
    }

    public void setListSymptom(List<Symptom> listSymptom) {
        this.listSymptom = listSymptom;
    }
}
