package ar.com.alehenestroza.apistarwars.services;

import ar.com.alehenestroza.apistarwars.dto.CharacterDTO;

import java.util.List;

public interface CharacterService {
    List<CharacterDTO> getCharactersThatContainName(String name);
}
