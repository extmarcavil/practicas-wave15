package com.starwar.starwarcharacters.controller;

import com.starwar.starwarcharacters.dto.CharacterDTO;
import com.starwar.starwarcharacters.service.CharacterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CharacterSearch {

    private CharacterService characterService;

    public CharacterSearch(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping("/findCharacter")
    public ResponseEntity<List<CharacterDTO>> findCharacter(@RequestParam String name) {

        return new ResponseEntity<>(characterService.getCharacters(name), HttpStatus.OK);
    }
}
