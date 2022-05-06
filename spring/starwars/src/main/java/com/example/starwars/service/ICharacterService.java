package com.example.starwars.service;


import com.example.starwars.dto.CharacterDTO;

import java.util.List;

public interface ICharacterService {

    /**
     * Metodos
     */
    List<CharacterDTO> listar();

    List<CharacterDTO> listarPorNombre(String query);
}
