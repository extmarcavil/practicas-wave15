package com.example.edadpersona.controller;

import com.example.edadpersona.model.Deporte;
import com.example.edadpersona.dtos.PersonaDTO;
import com.example.edadpersona.repository.DeportesRepository;
import com.example.edadpersona.repository.PersonasRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeportesController {

    @GetMapping("/findSports")
    public ResponseEntity<List<Deporte>> findSports() {
        return new ResponseEntity<>(DeportesRepository.getDeportes(), HttpStatus.OK);
    }

    @GetMapping("/findSports/{name}")
    public ResponseEntity<Deporte> findSportByName(@PathVariable String name) {
        return new ResponseEntity<>(DeportesRepository.getDeporteByName(name),
                DeportesRepository.getDeporteByName(name) != null ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<PersonaDTO>> findSportsPersons() {
        return new ResponseEntity<>(PersonasRepository.getPersonasDeportistas(), HttpStatus.OK);
    }
}
