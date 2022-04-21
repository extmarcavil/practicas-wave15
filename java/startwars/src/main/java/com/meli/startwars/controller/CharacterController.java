package com.meli.startwars.controller;

import com.meli.startwars.dto.CharacterDto;
import com.meli.startwars.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class CharacterController {

    private final CharacterService characterService;

    @Autowired
    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping("findByName/{name}")
    public ResponseEntity<List<CharacterDto>> findByName(@PathVariable String name) {
        return new ResponseEntity<>(characterService.findByName(name), HttpStatus.OK);
    }
}
