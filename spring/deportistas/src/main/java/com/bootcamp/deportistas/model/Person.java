package com.bootcamp.deportistas.model;

import lombok.Getter;

import lombok.Setter;

@Getter
@Setter
public class Person {

    String name;
    String lastName;
    Integer age;

    public Person() {
    }

    public Person(String name, String lastName, Integer age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }
}
