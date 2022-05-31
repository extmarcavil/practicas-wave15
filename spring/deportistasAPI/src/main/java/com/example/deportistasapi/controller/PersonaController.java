package com.example.deportistasapi.controller;

import com.example.deportistasapi.dto.PersonaDto;
import com.example.deportistasapi.service.IPersonaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PersonaController {

    private IPersonaService personaService;

    public PersonaController(IPersonaService personaService) {
        this.personaService = personaService;
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<PersonaDto>> findSportsPersons() {
        return new ResponseEntity<>(
                this.personaService.findSportsPersons()
                        .stream()
                        .map(PersonaDto::new)
                        .collect(Collectors.toList()),
                HttpStatus.OK
        );
    }
}
