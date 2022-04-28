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
public class CharacterController {

    ICharacterService characterService;

    public CharacterController(ICharacterService characterService){
        this.characterService = characterService;
    }

    @GetMapping("/buscar/{name}")
    public ResponseEntity<List<CharacterDTO>> getCharacters(@PathVariable String name){
        return new ResponseEntity<>(characterService.getCharacters(name), HttpStatus.OK);
    }

}
