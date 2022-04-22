package com.bootcamp.deportes.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {
    private String name;
    private String lastName;
    private int edad;

    public Person() {
    }

    public Person(String name, String lastName, int edad) {
        this.name = name;
        this.lastName = lastName;
        this.edad = edad;
    }
}
