package com.spring.covid19.repository;

import com.spring.covid19.model.Persona;
import com.spring.covid19.model.Sintoma;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class Covid19Impl implements Covid19Repository {

    private List<Sintoma> sintomas;
    private List<Persona> personas;

    public Covid19Impl() {
        this.sintomas = new ArrayList<>();
        this.personas = new ArrayList<>();
        inicializarDatos();
    }

    @Override
    public List<Sintoma> obtenerTodosSintomas() {
        return sintomas;
    }

    @Override
    public List<Persona> obtenerTodasPersonas() {
        return personas;
    }

    @Override
    public Optional<Sintoma> obtenerSintomaPorNombre(String nombre) {
        return sintomas.stream().filter(
                        sintoma -> sintoma.getNombre().equals(nombre))
                .findFirst();
    }

    @Override
    public List<Persona> obtenerPersonasDeRiesgo() {
        return personas.stream().filter(
                        persona -> persona.tieneSintomas() && persona.esMayor())
                .collect(Collectors.toList());
    }

    private void inicializarDatos() {
        this.sintomas.add(new Sintoma(1, "Dolor de cabeza", 1));
        this.sintomas.add(new Sintoma(2, "Tos", 2));
        this.sintomas.add(new Sintoma(3, "Fiebre", 3));
        this.sintomas.add(new Sintoma(4, "Dolor de garganta", 1));

        this.personas.add(new Persona(1, "Camila", "Lopez", 33, new ArrayList<>()));
        this.personas.add(new Persona(2, "Marcela", "Lopez", 66, sintomas));
        this.personas.add(new Persona(3, "Juan", "Perez", 70, new ArrayList<>()));
        this.personas.add(new Persona(4, "Carlos", "Mancilla", 60, new ArrayList<>()));
    }
}
