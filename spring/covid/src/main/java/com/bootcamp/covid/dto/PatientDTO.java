package com.bootcamp.covid.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PatientDTO {
    String           name;
    String lastname;
    List<SymptomDTO> symptoms;

    public PatientDTO ( String name, String lastname, List<SymptomDTO> symptoms ) {
        this.name     = name;
        this.lastname = lastname;
        this.symptoms = symptoms;
    }
}
