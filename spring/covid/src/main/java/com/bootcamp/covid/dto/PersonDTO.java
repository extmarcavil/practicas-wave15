package com.bootcamp.covid.dto;

import com.bootcamp.covid.model.Person;
import com.bootcamp.covid.model.Symptom;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PersonDTO {
    private String fullyName;
    private List<Symptom> symptomDTO;


    public PersonDTO(Person person) {
        this.fullyName = person.getName() +" "+ person.getLastName();
        this.symptomDTO = person.getSymptoms();
    }

}
