package com.meli.responseentity.persondto.model;

import org.springframework.lang.Nullable;

import java.util.List;

public class Person {

    private final Long id;
    private final String firstName;
    private final String lastName;
    private final int age;

    @Nullable
    private List<Sport> sports;

    public Person(Long id, String firstName, String lastName, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    @Nullable
    public List<Sport> getSports() {
        return sports;
    }

    public void setSports(List<Sport> sports) {
        this.sports = sports;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", sports=" + sports +
                '}';
    }
}
