package com.mercadolibre.covid.controller;

import com.mercadolibre.covid.dto.RiskPersonDto;
import com.mercadolibre.covid.model.Symptom;
import com.mercadolibre.covid.service.CovidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class CovidController {

    private final CovidService covidService;

    @Autowired
    public CovidController(CovidService covidService) {
        this.covidService = covidService;
    }

    @GetMapping("findSymptom")
    public List<Symptom> findSymptom() {
        return covidService.findAll();
    }

    @GetMapping("findSymptom/{name}")
    public ResponseEntity<Symptom> findSymptom(@PathVariable String name) {
        return new ResponseEntity<>(covidService.findByName(name), HttpStatus.OK);
    }

    @GetMapping("findRiskPerson")
    public List<RiskPersonDto> findRiskPerson() {
        return covidService.findAllRiskPerson();
    }

}
