package com.starwars.starwars.controller;

import com.starwars.starwars.dto.PersonajeDTO;
import com.starwars.starwars.servicio.PersonajeServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonajeController {
    PersonajeServicio personajeServicio;

    public PersonajeController(PersonajeServicio personajeServicio){
        this.personajeServicio = personajeServicio;
    }

    //Punto 1.
    @GetMapping("/{nombre}")
    public ResponseEntity<List<PersonajeDTO>> listSymptoms (@PathVariable String nombre) {
        return new ResponseEntity<>(personajeServicio.getPersonajesPorNombre(nombre), HttpStatus.OK);
    }
}
