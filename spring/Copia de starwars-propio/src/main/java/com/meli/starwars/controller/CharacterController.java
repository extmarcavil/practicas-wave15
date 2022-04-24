package com.meli.starwars.controller;

import com.meli.starwars.dto.CharacterDTO;
import com.meli.starwars.dto.CharacterResponseDTO;
import com.meli.starwars.repositories.CharacterRepository;
import com.meli.starwars.services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CharacterController {

    @Autowired
    CharacterService service;

    @GetMapping("/characters")
    public List<CharacterResponseDTO> getAllCharacters () {
        List<CharacterResponseDTO> list = service.getCharactersByName("Darth");
        return list;
    }
}
