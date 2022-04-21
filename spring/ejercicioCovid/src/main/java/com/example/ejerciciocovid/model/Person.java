package com.example.ejerciciocovid.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {

    private int id;
    private String name;
    private String lastName;
    private int age;

    public Person(int id, String name, String lastName, int age) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public boolean isOld() {
        return this.age > 59;
    }

}
