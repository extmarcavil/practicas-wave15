package com.example.starwars.service;

import com.example.starwars.repositories.CharacterRepository;
import com.example.starwars.dto.CharacterDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindService {
  private final CharacterRepository characterRepository;

  public FindService(CharacterRepository characterRepository) {
    this.characterRepository = characterRepository;
  }

  public List<CharacterDTO> find(String query) {
    return characterRepository.findAllByNameContains(query);
  }
}
