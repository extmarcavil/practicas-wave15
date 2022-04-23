package com.example.starwars.repositories;

import com.example.starwars.dto.CharacterDTO;
import com.example.starwars.dto.response.CharacterResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ICharacterRepository {
  List<CharacterDTO> findAllByNameContains(String query);
  CharacterDTO findByName(String name);
}
