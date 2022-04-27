package com.mercadolibre.covid.dto;

import com.mercadolibre.covid.model.Person;
import com.mercadolibre.covid.model.Symptom;

import java.util.List;
import java.util.Optional;

import static java.util.Collections.emptyList;

public class RiskPersonDto {

    private final String firstName;
    private final String lastName;
    private final List<Symptom> symptoms;

    private RiskPersonDto(String firstName, String lastName, List<Symptom> symptoms) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.symptoms = symptoms;
    }

    public static RiskPersonDto from(Person person) {
        return new RiskPersonDto(person.getFirstName(), person.getLastName(), getSymptomsFrom(person));
    }

    private static List<Symptom> getSymptomsFrom(Person person) {
        return Optional.ofNullable(person.getSymptoms())
                .orElse(emptyList());
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<Symptom> getSymptoms() {
        return symptoms;
    }

    @Override
    public String toString() {
        return "RiskPersonDto{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

}
