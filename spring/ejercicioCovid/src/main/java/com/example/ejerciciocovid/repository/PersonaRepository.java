package com.example.ejerciciocovid.repository;

import com.example.ejerciciocovid.model.Persona;

import java.util.ArrayList;
import java.util.List;

public class PersonaRepository {

    private static List<Persona> personas;
    static {
        personas = new ArrayList<Persona>();
        personas.add(new Persona(1, "Julio", "Ferreira", 65));
        personas.add(new Persona(2, "Milagros", "Carranza", 23));
        personas.add(new Persona(3, "Sandra", "Sanchez", 70));
    }

    public PersonaRepository() {
    }

    public List<Persona> getPersonasList() {
        return personas;
    }
}
