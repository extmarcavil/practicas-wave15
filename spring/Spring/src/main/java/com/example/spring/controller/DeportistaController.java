package com.example.spring.controller;

import com.example.spring.dto.DeporteDTO;
import com.example.spring.dto.DeportistaDTO;
import com.example.spring.entity.DeporteEntity;
import com.example.spring.entity.PersonaEntity;
import com.example.spring.service.DeportistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/")
public class DeportistaController {

    @Autowired
    DeportistaService deportistaService;


    @GetMapping("findSports")
    public ResponseEntity<List<DeporteEntity>> findSports() {
        return new ResponseEntity<>(deportistaService.findSports(), HttpStatus.OK);
    }

    @GetMapping("findPersons")
    public ResponseEntity<List<PersonaEntity>> findPersons() {
        return new ResponseEntity<>(deportistaService.findPersons(), HttpStatus.OK);
    }

    @GetMapping("findSport/{name}")
    public ResponseEntity<DeporteDTO> findSport(@PathVariable String name) {
        return new ResponseEntity<>(deportistaService.findSport(name), HttpStatus.OK);
    }

    @GetMapping("findSportsPersons")
    public ResponseEntity<List<DeportistaDTO>> findSportsPersons() {
        return new ResponseEntity<>(deportistaService.findSportsPersons(), HttpStatus.OK);
    }

    @PostMapping("addSport")
    public void saveSport(@RequestBody DeporteEntity sport) {
        deportistaService.saveSport(sport);
    }

    @PostMapping("addPerson")
    public void savePerson(@RequestBody PersonaEntity person) {
        deportistaService.savePerson(person);
    }

    @PostMapping("addSportPerson/{name}")
    public void saveSportPerson(@PathVariable String name, @RequestBody String sport) {
        deportistaService.saveSportPerson(name, sport);
    }
    
    
}
