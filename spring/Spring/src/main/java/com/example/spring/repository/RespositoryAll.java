package com.example.spring.repository;

import com.example.spring.entity.DeporteEntity;
import com.example.spring.entity.DeportePersonaEntity;
import com.example.spring.entity.PersonaEntity;

import java.util.ArrayList;
import java.util.List;

public class RespositoryAll {

    private List<PersonaEntity> personas;
    private List<DeporteEntity> deportes;
    private List<DeportePersonaEntity> deportesPersonas;


    public RespositoryAll() {
        this.personas = new ArrayList<>();
        this.deportes = new ArrayList<>();
        this.deportesPersonas = new ArrayList<>();
    }


    public void savePersona(PersonaEntity persona) {
        personas.add(persona);
    }

    public void saveSport(DeporteEntity sport) {
        deportes.add(sport);
    }

    public void saveSportPerson(DeportePersonaEntity deportePersona) { deportesPersonas.add(deportePersona); }

    public List<DeporteEntity> findAllSports() {
        return deportes;
    }

    public List<PersonaEntity> findAllPersons() {
        return personas;
    }

    public DeporteEntity findSportByName(String name) {

        for (DeporteEntity sport : deportes) {
            if (sport.getNombre().equals(name))
                return sport;
        }

        return null;
    }

    public PersonaEntity findPersonByName(String name) {

        for (PersonaEntity person : personas) {
            if (person.getNombre().equals(name))
                return person;
        }

        return null;
    }

    public List<DeportePersonaEntity> findSportsPersons() {
        return deportesPersonas;
    }

}
