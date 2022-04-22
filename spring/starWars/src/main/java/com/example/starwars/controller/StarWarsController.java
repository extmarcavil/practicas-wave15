package com.example.starwars.controller;

import com.example.starwars.dto.CharacterDTO;
import com.example.starwars.service.IStarWarsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/starwars")
public class StarWarsController {
    private IStarWarsService service;

    public StarWarsController(IStarWarsService service) {
        this.service = service;
    }

    @GetMapping("/personajes/{name}")
    public List<CharacterDTO> getCharacters(@PathVariable String name){
        return service.findAllByNameContains(name);
    }
}
