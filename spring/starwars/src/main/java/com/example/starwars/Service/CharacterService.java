package com.example.starwars.Service;

import com.example.starwars.dto.CharacterDTO;

import java.util.List;

public interface CharacterService {

    List<CharacterDTO> findByname(String name);


}
