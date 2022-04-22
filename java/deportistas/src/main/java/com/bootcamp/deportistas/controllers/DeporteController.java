package com.bootcamp.deportistas.controllers;

import com.bootcamp.deportistas.Repository.DeporteRepository;
import com.bootcamp.deportistas.Repository.PersonaRepository;
import com.bootcamp.deportistas.dtos.DeporteDTO;
import com.bootcamp.deportistas.dtos.PersonaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeporteController {

    @GetMapping("/findSports")
    public ResponseEntity<List<DeporteDTO>> findSports() {
        return new ResponseEntity<>(DeporteRepository.obtenerDeporte(), HttpStatus.OK);
    }

    @GetMapping("/findSports/{name}")
    public ResponseEntity<DeporteDTO> findSportsByName(@PathVariable String name) {
        return new ResponseEntity<>(DeporteRepository.obtenerDeportePorNombre(name),
                DeporteRepository.obtenerDeportePorNombre(name) != null ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/findSportsPerson")
    public ResponseEntity<List<PersonaDTO>> findSportsPerson() {
        return new ResponseEntity<>(PersonaRepository.buscarPersonasDeportistas(),HttpStatus.OK);
    }
}
