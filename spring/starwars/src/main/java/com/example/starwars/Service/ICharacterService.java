package com.example.starwars.Service;

import com.example.starwars.dto.CharacterDTO;
import com.example.starwars.dto.ResponseCharacterDTO;

import java.util.List;

public interface ICharacterService {
     List<CharacterDTO> findchar(String name);
}
