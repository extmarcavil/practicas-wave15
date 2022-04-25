package com.bootcamp.starwars.service;

import com.bootcamp.starwars.dto.PersonajeDTO;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface IStarWarsService {
    List<PersonajeDTO> getCharacterByName(String name);
}
