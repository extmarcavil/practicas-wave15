package com.spring.covid19.service;

import com.spring.covid19.dto.PersonaDTO;
import com.spring.covid19.model.Persona;
import com.spring.covid19.model.Sintoma;
import com.spring.covid19.repository.Covid19Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class Covid19ServiceImpl implements Covid19Service {

    @Autowired
    private Covid19Repository repository;

    @Override
    public List<PersonaDTO> getPersonasDeRiesgoConSintomas() {
        List<Persona> personasDeRiesgo = repository.obtenerPersonasDeRiesgo();
        return converterPersonas(personasDeRiesgo);
    }

    @Override
    public List<Sintoma> getSintomas() {
        return repository.obtenerTodosSintomas();
    }

    @Override
    public List<Persona> getPersonas() {
        return repository.obtenerTodasPersonas();
    }

    @Override
    public Sintoma getSintoma(String nombre) {
        try {
            return repository.obtenerSintomaPorNombre(nombre).get();
        } catch (RuntimeException e) {
            return null;
        }
    }

    private List<PersonaDTO> converterPersonas(List<Persona> personas) {
        return personas.stream().map(
                        persona -> new PersonaDTO(persona.getNombre(), persona.getApellido(), persona.getSintomas()))
                .collect(Collectors.toList());
    }

}
