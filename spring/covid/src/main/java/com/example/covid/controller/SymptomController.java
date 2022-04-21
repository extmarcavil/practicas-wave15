package com.example.covid.controller;

import com.example.covid.dto.PersonDTO;
import com.example.covid.dto.SymptomDTO;
import com.example.covid.service.ISymptomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/covid")
public class SymptomController {

    private final ISymptomService service;

    public SymptomController(ISymptomService service) {
        this.service = service;
    }

    @GetMapping("/findSymptom")
    public ResponseEntity<List<SymptomDTO>> findSymptom(){
        return new ResponseEntity<>(service.getSymptons(), HttpStatus.OK);
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<SymptomDTO> findSymptom(@PathVariable String name){
        return new ResponseEntity<>(service.getSymptomSeverityLevelDTO(name), HttpStatus.OK);
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<PersonDTO>> findRiskPerson(){
        return new ResponseEntity<>(service.getRiskPersonsDTO(), HttpStatus.OK);
    }
}
