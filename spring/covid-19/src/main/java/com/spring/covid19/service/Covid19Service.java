package com.spring.covid19.service;

import com.spring.covid19.dto.PersonaDTO;
import com.spring.covid19.model.Persona;
import com.spring.covid19.model.Sintoma;

import java.util.List;

public interface Covid19Service {

    List<PersonaDTO> getPersonasDeRiesgoConSintomas();

    List<Sintoma> getSintomas();

    List<Persona> getPersonas();

    Sintoma getSintoma(String nombre);
}
