package com.ejercicio.starwarsproject.controllers;


import com.ejercicio.starwarsproject.dto.PersonajeDTO;
import com.ejercicio.starwarsproject.models.Personaje;
import com.ejercicio.starwarsproject.services.PersonajeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PersonajeController {
    private final PersonajeService personajeService;

    @GetMapping("/showListCharacterByName/{name}")
    public ResponseEntity<List<PersonajeDTO>> showListPersonajes(@PathVariable String name){
        return new ResponseEntity<>(personajeService.findAllByNameContains(name), HttpStatus.OK);
    }

}
