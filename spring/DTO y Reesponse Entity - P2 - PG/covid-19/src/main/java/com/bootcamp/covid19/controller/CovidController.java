package com.bootcamp.covid19.controller;

import com.bootcamp.covid19.dtos.PatientDTO;
import com.bootcamp.covid19.dtos.SymptomDTO;
import com.bootcamp.covid19.service.CovidService;
import com.bootcamp.covid19.service.ICovidService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CovidController {

    ICovidService covidService;

    public CovidController(ICovidService covidService){
        this.covidService = covidService;
    }

    @GetMapping("/findSymptom")
    public ResponseEntity<List<SymptomDTO>> findSymptom() {
        return new ResponseEntity<>(covidService.findSymptom(), HttpStatus.OK);
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<SymptomDTO> findSymptomByName(@PathVariable String name) {
        SymptomDTO symptom = covidService.findSymptomByName(name);
        if (symptom == null)
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        return ResponseEntity.status(200).body(symptom);
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<PatientDTO>> findRiskPerson() {
        return new ResponseEntity<>(covidService.findRiskPerson(), HttpStatus.OK);
    }

}
