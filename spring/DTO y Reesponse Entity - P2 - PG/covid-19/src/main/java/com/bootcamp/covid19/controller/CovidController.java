package com.bootcamp.covid19.controller;

import com.bootcamp.covid19.dtos.SickDTO;
import com.bootcamp.covid19.dtos.SymptomDTO;
import com.bootcamp.covid19.model.Symptom;
import com.bootcamp.covid19.repository.PersonRepository;
import com.bootcamp.covid19.repository.SymptomRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CovidController {
    SymptomRepository symptomRepository = new SymptomRepository();
    PersonRepository personRepository = new PersonRepository();

    @GetMapping("/findSymptom")
    public ResponseEntity<List<SymptomDTO>> findSymptom() {
        return new ResponseEntity<>(symptomRepository.findSymptom(), HttpStatus.OK);
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<SymptomDTO> findSymptomByName(@PathVariable String name) {
        SymptomDTO symptom = symptomRepository.findSymptomByName(name);
        if (symptom == null)
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        return ResponseEntity.status(200).body(symptom);
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<SickDTO>> findRiskPerson() {
        return new ResponseEntity<>(personRepository.findRiskPerson(), HttpStatus.OK);
    }

}
