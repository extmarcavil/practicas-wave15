package com.springp2pg.covid19.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Person {

    private Long id;
    private String name;
    private String lastName;
    private int age;
    private List<Symptom> symptoms;

    public Person(Long id, String name, String lastName, int age, List<Symptom> symptoms) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.symptoms = symptoms;
    }
}
