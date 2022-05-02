package com.bootcamp.starWors.controllers;

import com.bootcamp.starWors.dtos.PersonajeSWDTO;
import com.bootcamp.starWors.services.DatosPersonajesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/personaje")
public class PersonajeController {

    private DatosPersonajesService datosPersonajesService;

    public PersonajeController(DatosPersonajesService datosPersonajesService) {
        this.datosPersonajesService = datosPersonajesService;
    }

    @GetMapping("/{namePersonaje}")
    public ResponseEntity<List<PersonajeSWDTO>> getCharacterByName(@PathVariable String namePersonaje){
        return new ResponseEntity<>(datosPersonajesService.findCharacter(namePersonaje), HttpStatus.OK);
    }

}
