package com.vparula.starwars.controller;

import com.vparula.starwars.dto.PersonajeDTO;
import com.vparula.starwars.service.IServicePersonaje;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StarWarsController {
    private final IServicePersonaje service;

    public StarWarsController(IServicePersonaje service) {
        this.service = service;
    }

    @GetMapping("/getByName")
    public List<PersonajeDTO> getByName(@RequestParam String name){
        return service.devuelvoPersonaje(name);
    }
}
