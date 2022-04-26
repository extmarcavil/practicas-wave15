package com.example.starwars.service;

import com.example.starwars.model.CharacterStar;
import com.example.starwars.repositories.CharacterRepository;
import com.example.starwars.dto.CharacterDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FindService {
  private final CharacterRepository characterRepository;

  public FindService(CharacterRepository characterRepository) {
    this.characterRepository = characterRepository;
  }

  public List<CharacterDTO> find(String query) {
    return characterRepository.findAllByNameContains(query)
            .stream()
            .map(characterStar -> new CharacterDTO(
                    characterStar.getName(),
                    characterStar.getGender(),
                    characterStar.getHomeworld(),
                    characterStar.getSpecies(),
                    characterStar.getHeight(),
                    characterStar.getMass()))
            .collect(Collectors.toList());
  }
}
