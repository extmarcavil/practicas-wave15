package com.example.deportistas.models;

public class Person {
    private String name;
    private String lastName;
    private int age;
    private Sport sport;

    public Person(String name, String lastName, int age, Sport sport) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.sport = sport;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }
}
