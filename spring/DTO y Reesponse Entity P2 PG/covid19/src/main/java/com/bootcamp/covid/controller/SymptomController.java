package com.bootcamp.covid.controller;

import com.bootcamp.covid.dto.PatientDTO;
import com.bootcamp.covid.dto.SymptomDTO;
import com.bootcamp.covid.service.ISymptomService;
import com.bootcamp.covid.service.SymptomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SymptomController {

    ISymptomService service;

    public SymptomController (  ISymptomService service) {
        this.service = service;
    }

    @GetMapping("/symptoms")
    public ResponseEntity<List<SymptomDTO>> listSymptoms () {
        return new ResponseEntity<>(service.getSymptoms(), HttpStatus.OK);
    }

    @GetMapping("/symptoms/{name}")
    public ResponseEntity<SymptomDTO> getSymptom ( @PathVariable String name ) {
        return new ResponseEntity<>(service.getSymptomDTO(name), HttpStatus.OK);
    }

    @GetMapping("/risk-people")
    public ResponseEntity<List<PatientDTO>> getRiskPeople () {
        return new ResponseEntity<>(service.getPatients(), HttpStatus.OK);
    }
}
