package com.spring.deportistas.repository;

import com.spring.deportistas.model.Deporte;
import com.spring.deportistas.model.Persona;

import java.util.ArrayList;
import java.util.List;

public class DeportistasImpl {

    private List<Deporte> deportes;
    private List<Persona> personas;

    public DeportistasImpl() {
        deportes = new ArrayList<>();
        personas = new ArrayList<>();
        inicializarDatos();
    }

    private void inicializarDatos() {
        this.personas.add(new Persona("Camila", "Lopez", 22, new Deporte("Futbol", 1)));
        this.personas.add(new Persona("Azul", "Lopez", 66, new Deporte("Futbol", 2)));
        this.personas.add(new Persona("Carlos", "Lopez", 70, new Deporte("Voley", 2)));
        this.personas.add(new Persona("Tomas", "Molina", 20, new Deporte("Voley", 1)));

        this.deportes.add(new Deporte("Voley", 1));
        this.deportes.add(new Deporte("Voley", 2));
        this.deportes.add(new Deporte("Futbol", 2));
    }

    public List<Deporte> getDeportes() {
        return deportes;
    }

    public List<Persona> getPersonas() {
        return personas;
    }
}
