package com.springp2pg.covid19.controller;

import com.springp2pg.covid19.dto.RiskPersonDTO;
import com.springp2pg.covid19.dto.SymptomDTO;
import com.springp2pg.covid19.entity.Person;
import com.springp2pg.covid19.entity.Symptom;
import com.springp2pg.covid19.service.ICovidService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


//Implementacion de capa servicio y repositorio
//Para el metodo findAllSymtom, se usa la clase Symptom como si fuera DTO, para no hacer un mapeo de clases a mano.

@RestController
public class CovidController {

    private ICovidService covidService;



    public CovidController(ICovidService covidService) {
        this.covidService = covidService;
    }

    @GetMapping("/findSymptom")
    ResponseEntity<List<Symptom>> findAllSymtom(){
        return new ResponseEntity<>(covidService.getAllSymptom(), HttpStatus.OK);
    }

    @GetMapping("findSymptom/{name}")
    ResponseEntity<SymptomDTO> findSymptom(@PathVariable String name){
            return new ResponseEntity<>(covidService.findSymptom(name), HttpStatus.OK);

    }

    @GetMapping("/findRiskPerson")
    ResponseEntity<List<RiskPersonDTO>> findRiskPerson(){
            return new ResponseEntity<>(covidService.findRiskPeople(), HttpStatus.OK);
    }
}
