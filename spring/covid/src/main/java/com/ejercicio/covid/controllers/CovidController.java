package com.ejercicio.covid.controllers;

import com.ejercicio.covid.dtos.PersonaDTO;
import com.ejercicio.covid.dtos.SintomaDTO;
import com.ejercicio.covid.service.CovidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CovidController {

    @Autowired
    private CovidService covidService;

    @GetMapping("/findSymptom")
    public List<SintomaDTO> findSymptom() {
        return covidService.findSymptom();
    }
    @GetMapping("/findSympton/{name}")
    public ResponseEntity<String> findSymptomByName(@PathVariable String name){
        return new ResponseEntity<> (covidService.findSymptomByName(name), HttpStatus.OK);
    }

    @GetMapping("/findRiskPerson")
    public List<PersonaDTO> findRiskPerson(){
        return covidService.findRiskPerson();
    }






}
