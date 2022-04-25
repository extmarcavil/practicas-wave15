package com.p1vivo.starwars.controller;

import com.p1vivo.starwars.dto.CharacterDTO;
import com.p1vivo.starwars.service.IStarWarsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;

// Ejercicio sin usar mapeo de clases

@RestController
public class StarWarsController {
    
    private IStarWarsService starWarsService;

    public StarWarsController(IStarWarsService starWarsService) {
        this.starWarsService = starWarsService;
    }
    
    @GetMapping("/findCharacters/{name}")
    public ResponseEntity<List<CharacterDTO>> getAllCharactersByNameContains (@PathVariable String name){
        return new ResponseEntity<>(starWarsService.findAllByNameContains(name), HttpStatus.OK);
    }
}
