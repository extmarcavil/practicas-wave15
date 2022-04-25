package com.Spring.StarWars.controller;

import com.Spring.StarWars.dto.PersonajeFiltradoDTO;
import com.Spring.StarWars.service.IPersonajeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonajeController {

    IPersonajeService service;

    PersonajeController(IPersonajeService service){
        this.service = service;
    }

    @GetMapping("/{filtro}")
    public ResponseEntity<List<PersonajeFiltradoDTO>> listarPersonajesFiltrados(@PathVariable String filtro){
        return new ResponseEntity<List<PersonajeFiltradoDTO>>(service.listarPersonajesFiltrados(filtro), HttpStatus.OK);
    }
}
