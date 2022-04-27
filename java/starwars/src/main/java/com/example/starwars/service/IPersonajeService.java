package com.example.starwars.service;

import com.example.starwars.dto.CharacterDTO;

public interface IPersonajeService {

    CharacterDTO getPersonajeData(String name);
}
