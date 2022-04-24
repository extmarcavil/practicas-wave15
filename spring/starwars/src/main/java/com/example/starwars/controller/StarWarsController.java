package com.example.starwars.controller;

import com.example.starwars.dto.CharacterDTO;
import com.example.starwars.repositories.ICharacterRepository;
import com.example.starwars.service.ICharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StarWarsController {

    @Autowired
    ICharacterService service;

    @GetMapping("/prueba/{name}")
    public List<CharacterDTO> listaprueba(@PathVariable String name){
       return service.findAllByNameContains(name);
    }
}
