package com.covid19.controller;

import com.covid19.dto.EnfermoDTO;
import com.covid19.dto.SintomaDTO;
import com.covid19.model.Sintoma;
import com.covid19.repository.PersonaRepository;
import com.covid19.repository.SintomaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RestController
public class SintomasController {

    SintomaRepository sintomaRepository = new SintomaRepository();
    PersonaRepository personaRepository = new PersonaRepository();

    @GetMapping(value="/findSymptom")
    public ResponseEntity<List<SintomaDTO>> findSymptom() {
        return new ResponseEntity<>(sintomaRepository.findSymptom(), HttpStatus.OK);
    }

    @GetMapping(value="/findSymptom/{name}")
    public ResponseEntity<Sintoma> findSymptomByName(@PathVariable String name) {
        Sintoma sintoma = sintomaRepository.findSymptomByName(name);
        if (sintoma == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } else {
           return ResponseEntity.status(200).body(sintoma);
        }
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<EnfermoDTO>> findRiskPerson() {
        return new ResponseEntity<>(personaRepository.findRiskPerson(), HttpStatus.OK);
    }


}

    

