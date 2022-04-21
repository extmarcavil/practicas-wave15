package com.example.covid.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class Person {
    private int id;
    private String name;
    private String lastname;
    private int age;
    private List<Symptom> symptoms;

    public Person(int id, String name, String lastname, int age, List<Symptom> symptoms) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.symptoms = symptoms;
    }

    public Person(int id, String name, String lastname, int age) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.symptoms = new ArrayList<>();
    }

    public String getSymptomsString() {
        return symptoms.stream().map(s -> s.getName()).collect(Collectors.joining(", "));
    }
}
