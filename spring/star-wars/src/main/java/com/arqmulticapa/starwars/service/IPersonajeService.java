package com.arqmulticapa.starwars.service;

import com.arqmulticapa.starwars.dto.PersonajeDTO;

import java.util.List;

public interface IPersonajeService {
    List<PersonajeDTO> findByNameContains(String name);
}
