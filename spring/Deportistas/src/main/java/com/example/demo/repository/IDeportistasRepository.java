package com.example.demo.repository;

import com.example.demo.model.Deporte;
import com.example.demo.model.Persona;

import java.util.List;

public interface IDeportistasRepository {

    List<Deporte> getSports();

    int getLevel(String name);

    List<Persona> getPersons();
}
