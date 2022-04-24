package com.meli.covid.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter @Getter
public class Person {
    private Number id;
    private String name;
    private String surname;
    private Number age;
    private List<Symptom> personalSymptoms;

    public Person(Number id, String name, String surname, Number age, List<Symptom> personalSymptoms) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.personalSymptoms = personalSymptoms;
    }
}
