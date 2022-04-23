package com.example.starwars.service;

import com.example.starwars.dto.CharacterDTO;
import com.example.starwars.dto.response.CharacterResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IBuscarPersonajeService {
    ResponseEntity<CharacterResponseDTO> findByName(String name);
    List<CharacterDTO> findAllByNameContains (String query );
}
