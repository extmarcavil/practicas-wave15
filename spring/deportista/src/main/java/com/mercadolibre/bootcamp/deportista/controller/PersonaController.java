package com.mercadolibre.bootcamp.deportista.controller;

import com.mercadolibre.bootcamp.deportista.dto.PersonaRequestDto;
import com.mercadolibre.bootcamp.deportista.dto.PersonaResponseDto;
import com.mercadolibre.bootcamp.deportista.service.ICRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persona")
public class PersonaController {

    /**
     * InjectionOf Dependency
     */
    @Autowired
    @Qualifier("personaService")
    private ICRUDService personaService;


    /**
     * Metodos
     */
    @PostMapping("/save")
    public PersonaResponseDto save(@RequestBody PersonaRequestDto persona) {
        return (PersonaResponseDto) personaService.save(persona);
    }


    @GetMapping("/findSportsPerson")
    public List<PersonaResponseDto> findAll() {
        return personaService.findAll();
    }
}
