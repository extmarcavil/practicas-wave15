package com.example.deportistas.repositories;

import com.example.deportistas.model.Persona;

import java.util.List;

public interface IPersonaRepo {
    void addPersona (Persona persona);
    void addAllPersonas(List<Persona> personas);
    List<Persona> getPersonas();
}
