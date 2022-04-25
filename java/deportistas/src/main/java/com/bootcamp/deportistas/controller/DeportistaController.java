package com.bootcamp.deportistas.controller;

import com.bootcamp.deportistas.dto.DeporteDTO;
import com.bootcamp.deportistas.dto.PersonaDTO;
import com.bootcamp.deportistas.service.DeportistaService;
import com.bootcamp.deportistas.service.IDeportistaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/deporte/")
public class DeportistaController {
    IDeportistaService service;

    public DeportistaController(IDeportistaService service) {
        this.service = service;
    }

    @GetMapping("/findSport")
    public ResponseEntity<List<DeporteDTO>> findSports(){
        return new ResponseEntity<>(service.getSports(), HttpStatus.OK);
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<PersonaDTO>> findSportsPersons(){
        return new ResponseEntity<>(service.getSportsPersons(), HttpStatus.OK);
    }

    @GetMapping("/findSport/{sportName}")
    public ResponseEntity<DeporteDTO> findSportByName(@PathVariable String sportName) {
        return new ResponseEntity<>(service.getSportDTO(sportName), HttpStatus.OK);
    }
}
