package com.bootcamp.starwars.controller;

import com.bootcamp.starwars.dto.PersonajeDTO;
import com.bootcamp.starwars.service.IStarWarsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/starwars/")
public class StarWarsController{

    IStarWarsService service;

    public StarWarsController(IStarWarsService service) {
        this.service = service;
    }

    @GetMapping("/getCharacterByName/{name}")
    public ResponseEntity<List<PersonajeDTO>> getCharacterByName(@PathVariable String name){
        List<PersonajeDTO> characters = new ArrayList<>();
        return new ResponseEntity<>(service.getCharacterByName(name), HttpStatus.OK);
    }
}
