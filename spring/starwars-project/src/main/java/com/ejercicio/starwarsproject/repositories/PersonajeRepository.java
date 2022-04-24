package com.ejercicio.starwarsproject.repositories;

import com.ejercicio.starwarsproject.dto.PersonajeDTO;
import com.ejercicio.starwarsproject.models.Personaje;

import java.util.List;

public interface PersonajeRepository {

    List<Personaje> findAllByNameContains(String query);
}
