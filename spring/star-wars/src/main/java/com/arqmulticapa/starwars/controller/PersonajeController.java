package com.arqmulticapa.starwars.controller;

import com.arqmulticapa.starwars.dto.PersonajeDTO;
import com.arqmulticapa.starwars.service.IPersonajeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PersonajeController {
    private final IPersonajeService service;

    @GetMapping
    public List<PersonajeDTO> index(@RequestParam String name){
        return service.findByNameContains(name);
    }
}
