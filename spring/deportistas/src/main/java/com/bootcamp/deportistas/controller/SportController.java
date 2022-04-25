package com.bootcamp.deportistas.controller;

import com.bootcamp.deportistas.dto.PersonDTO;
import com.bootcamp.deportistas.dto.SportDTO;
import com.bootcamp.deportistas.service.ISportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SportController {

    ISportService service;

    public SportController(ISportService service) {
        this.service = service;
    }

    @GetMapping("/findSports")
    public ResponseEntity<List<SportDTO>> sports() {
        return new ResponseEntity<>(service.getSports(), HttpStatus.OK);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<SportDTO> sport(@PathVariable String name) {
        return new ResponseEntity<>(service.getSport(name), HttpStatus.OK);
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<PersonDTO>> people(){
        return new ResponseEntity<>(service.getPeople(), HttpStatus.OK);
    }
}
