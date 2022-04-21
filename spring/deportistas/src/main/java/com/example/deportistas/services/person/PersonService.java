package com.example.deportistas.services.person;

import com.example.deportistas.model.Deporte;
import com.example.deportistas.model.Persona;

import java.util.ArrayList;
import java.util.List;

public interface PersonService {
    void addPersona (Persona persona);
    void addAllPersonas(List<Persona> personas);
    void addDeporte(Persona p, Deporte d);
    void addAllDeportes(Persona p, List<Deporte> deporteList);
    List<Persona> findAll();
}
