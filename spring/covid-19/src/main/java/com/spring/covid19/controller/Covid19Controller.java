package com.spring.covid19.controller;

import com.spring.covid19.dto.PersonaDTO;
import com.spring.covid19.model.Sintoma;
import com.spring.covid19.service.Covid19ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Covid19Controller {

    @Autowired
    private Covid19ServiceImpl service;

    @GetMapping("/findSymptom")
    public ResponseEntity<List<Sintoma>> findAllSymptoms() {
        return new ResponseEntity<>(service.getSintomas(), HttpStatus.OK);
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<String> findSymptom(@PathVariable String name) {
        return new ResponseEntity<>("Nivel de gravedad: " + service.getSintoma(name).getNivelDeGravedad(), HttpStatus.OK);
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<PersonaDTO>> findRiskPersons() {
        return new ResponseEntity<>(service.getPersonasDeRiesgoConSintomas(), HttpStatus.OK);
    }


}
