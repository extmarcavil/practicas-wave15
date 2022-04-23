package com.bootcamp.Covid19.repository;

import com.bootcamp.Covid19.model.Persona;
import com.bootcamp.Covid19.model.Symptom;
import org.apache.el.parser.AstListData;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Repository
public class PersonaRepo implements IPersonaRepo{
    private final List<Persona> personas;

    public PersonaRepo() {
        personas = new ArrayList<>();
        initDataPersona();
    }

    @Override
    public List<Persona> getRiskPeople(){
        return personas.stream()
                .filter(persona -> persona.isOld() && persona.hasSymptoms())
                .collect(Collectors.toList());
    }

    private void initDataPersona() {
        List <Symptom> sintomas = new ArrayList<>();
        sintomas.add(new Symptom(1, "headache", "Low"));
        sintomas.add(new Symptom(4, "fatigue", "Low"));
        sintomas.add(new Symptom(5, "musclePain", "Low"));

        Persona mateo = new Persona(1, 25, "Mateo", "Loyarte", new ArrayList<>());
        Persona martin = new Persona(2, 65, "Martin", "Bermudez", sintomas);
        Persona roque = new Persona(3, 75, "Roque", "Fernandez", sintomas);
        Persona carlos = new Persona(4, 61, "Carlos", "Gonzalez", sintomas);

        this.personas.addAll(Arrays.asList(mateo, martin, carlos, roque));
    }
}
