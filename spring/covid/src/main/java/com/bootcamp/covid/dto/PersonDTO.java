package com.bootcamp.covid.dto;

import com.bootcamp.covid.model.Person;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonDTO {
    private  String fullyName;

    public PersonDTO(Person person) {
        this.fullyName = person.getName() +" "+ person.getLastName();
    }
}
