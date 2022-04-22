package com.example.starwars.controller;

import com.example.starwars.dto.CharacterDTO;
import com.example.starwars.service.ICharacterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StarWarsCharacters {
    ICharacterService service;

    public StarWarsCharacters(ICharacterService service) {
        this.service = service;
    }

    @GetMapping("/starWars/{name}")
    public ResponseEntity<List<CharacterDTO>> findCharactersPath (@PathVariable String name) {
        return new ResponseEntity<>(service.getCharacter(name), HttpStatus.OK);
    }

}
