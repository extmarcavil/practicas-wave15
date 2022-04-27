package com.meli.responseentity.persondto.dto;

import com.meli.responseentity.persondto.model.Person;
import com.meli.responseentity.persondto.model.Sport;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SportPersonDto implements Serializable {

    private final String firstName;
    private final String lastName;
    private final List<String> sports;

    private SportPersonDto(String firstName, String lastName, List<String> sports) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sports = sports;
    }

    public static SportPersonDto from(Person person) {
        return new SportPersonDto(person.getFirstName(), person.getLastName(), getNameSport(person.getSports()));
    }

    private static List<String> getNameSport(List<Sport> sports) {
        return Optional.ofNullable(sports)
                .map(element -> element.stream()
                        .map(Sport::getName)
                        .collect(Collectors.toList()))
                .orElse(Collections.emptyList());
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<String> getSports() {
        return sports;
    }

    @Override
    public String toString() {
        return "SportPersonDto{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", sports=" + sports +
                '}';
    }
}
