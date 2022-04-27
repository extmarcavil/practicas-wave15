package com.example.starwars.controller;

import com.example.starwars.dto.CharacterDTO;
import com.example.starwars.service.IPersonajeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonajeController {

    //Inyeccion de dependencias
    IPersonajeService service;

    PersonajeController( IPersonajeService service){
        this.service = service;
    }

    @GetMapping(path = "/{name}")
    public ResponseEntity<CharacterDTO> getPersonaje(@PathVariable String name){
    return new ResponseEntity<>(service.getPersonajeData(name), HttpStatus.OK);
    }

}
