package com.mercadolibre.covid.model;

import org.springframework.lang.Nullable;

import java.util.List;
import java.util.Objects;

public class Person {

    private final Long id;
    private final String firstName;
    private final String lastName;
    private final int age;
    @Nullable
    private List<Symptom> symptoms;

    public Person(Long id, String firstName, String lastName, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public boolean isRiskPerson() {
        return this.age > 60 && !Objects.requireNonNull(this.symptoms).isEmpty();
    }

    public void addSymptom(List<Symptom> symptoms) {
        this.symptoms = symptoms;
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
    public List<Symptom> getSymptoms() {
        return symptoms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(id, person.id) && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", symptoms=" + symptoms +
                '}';
    }
}
