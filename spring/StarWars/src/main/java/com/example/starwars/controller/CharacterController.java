package com.example.starwars.controller;

import com.example.starwars.dto.CharacterDTO;
import com.example.starwars.dto.CharacterShowDTO;
import com.example.starwars.service.ICharacterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CharacterController {

    ICharacterService service;
    public CharacterController(ICharacterService service) {
        this.service = service;
    }

    @GetMapping("/findCharacter/{name}")
    ResponseEntity<List<CharacterShowDTO>> findCharacter(@PathVariable String name){
        return new ResponseEntity<>(service.getCharacters(name), HttpStatus.OK);
    }
}
