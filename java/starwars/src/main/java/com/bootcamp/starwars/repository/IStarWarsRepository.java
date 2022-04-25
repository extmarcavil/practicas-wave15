package com.bootcamp.starwars.repository;

import com.bootcamp.starwars.dto.PersonajeDTO;

import java.util.List;

public interface IStarWarsRepository {
    List<PersonajeDTO> getCharacterByName(String name);
}
