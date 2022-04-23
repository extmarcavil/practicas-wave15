package com.starwars.starwars.repository;

import com.starwars.starwars.dto.PersonajeDTO;

import java.util.List;

public interface PersonajeRepositorio {
    public List<PersonajeDTO> getPersonajesPorNombre(String nombre);
}
