package com.spring.covid19.repository;

import com.spring.covid19.model.Persona;
import com.spring.covid19.model.Sintoma;

import java.util.List;
import java.util.Optional;

public interface Covid19Repository {

    List<Sintoma> obtenerTodosSintomas();

    List<Persona> obtenerTodasPersonas();

    Optional<Sintoma> obtenerSintomaPorNombre(String nombre);

    List<Persona> obtenerPersonasDeRiesgo();

}
