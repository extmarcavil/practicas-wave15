package com.bootcamp.Covid19.model;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Persona {

    private int id, edad;
    private String name, surname;
    private List<Symptom> simptoms;

    public Persona(int id, int edad, String name, String surname, List<Symptom> simptoms) {
        this.id = id;
        this.edad = edad;
        this.name = name;
        this.surname = surname;
        this.simptoms = simptoms;

    }

    public boolean isOld(){return this.edad > 60;}
    public boolean hasSymptoms(){return !this.simptoms.isEmpty();}

}
