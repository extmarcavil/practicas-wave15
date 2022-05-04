package com.example.starwars.controller;

import com.example.starwars.dto.CharacterDTO;
import com.example.starwars.model.Character;
import com.example.starwars.service.ICharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/character")
public class CharacterController {

    @Autowired
    private ICharacterService characterService;

    @GetMapping()
    public ResponseEntity<List<CharacterDTO>> findCharacters(@RequestParam(defaultValue = "") String name){
        List<Character> resultado = characterService.getCharactersByName(name);
        return ResponseEntity.ok(resultado.stream().map(c -> new CharacterDTO(c.getName(), c.getGender(), c.getHomeworld(), c.getSpecies(), c.getHeight(), c.getMass())).collect(Collectors.toList()));
    }
}
