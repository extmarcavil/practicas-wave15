package com.example.deportistasapi.service;

import com.example.deportistasapi.model.Persona;

import java.util.List;

public interface IPersonaService {

    List<Persona> findSportsPersons();
}
