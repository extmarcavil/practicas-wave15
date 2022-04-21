package com.example.ejerciciocovid.service;

import com.example.ejerciciocovid.model.Persona;
import com.example.ejerciciocovid.repository.PersonaRepository;

import java.util.List;

public class PersonaService {
    private PersonaRepository personaRepo = new PersonaRepository();

    public PersonaService() {
    }

    public List<Persona> getPersonasList() {
        return personaRepo.getPersonasList();
    }
}
