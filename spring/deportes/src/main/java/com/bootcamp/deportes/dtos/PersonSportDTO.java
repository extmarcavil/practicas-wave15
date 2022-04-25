package com.bootcamp.deportes.dtos;

import com.bootcamp.deportes.model.Person;
import com.bootcamp.deportes.model.Sport;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonSportDTO {
    private String fullyName;
    private String sport;

    public PersonSportDTO(Person person, Sport sport) {
        this.fullyName = person.getName() + " " + person.getLastName();
        this.sport = sport.getName();
    }
}
