package com.apicovid19.controllers;

import com.apicovid19.dtos.PersonaDTO;
import com.apicovid19.models.Persona;
import com.apicovid19.services.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/persona")
public class PersonaController {
    @Autowired
    private IPersonaService _personaService;


    @PostMapping
    public int agregarPersona(@RequestBody PersonaDTO persona)
    {
        return _personaService.agregarPersona(persona);
    }

    @GetMapping
    public ResponseEntity<ArrayList<PersonaDTO>> getPersonas()
    {
        return new ResponseEntity<>(_personaService.buscarPersonas(), HttpStatus.OK);
    }
}
