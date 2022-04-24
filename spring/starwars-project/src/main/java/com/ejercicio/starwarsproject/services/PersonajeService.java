package com.ejercicio.starwarsproject.services;

import com.ejercicio.starwarsproject.dto.PersonajeDTO;
import com.ejercicio.starwarsproject.models.Personaje;

import java.util.List;

public interface PersonajeService {

    List<PersonajeDTO> findAllByNameContains(String query);
}
