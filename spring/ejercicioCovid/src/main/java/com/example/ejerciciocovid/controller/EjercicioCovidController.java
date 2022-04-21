package com.example.ejerciciocovid.controller;

import com.example.ejerciciocovid.dto.RiskPersonDTO;
import com.example.ejerciciocovid.dto.SymptomDTO;
import com.example.ejerciciocovid.service.IPersonService;
import com.example.ejerciciocovid.service.ISymptomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class EjercicioCovidController {

    private ISymptomService symptomService;
    private IPersonService personService;

    public EjercicioCovidController(ISymptomService symptomService, IPersonService personService) {
        this.symptomService = symptomService;
        this.personService = personService;
    }

    @GetMapping("/findSymptom")
    @ResponseBody
    public ResponseEntity<List<SymptomDTO>> findSymptom(){
        return new ResponseEntity<>(symptomService.getSymptomsList(), HttpStatus.OK);
    }


    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<SymptomDTO> findSymptomByName(@PathVariable String name){
        SymptomDTO symptom = symptomService.getSymptomDTO(name);

        if (symptom != null)
            return new ResponseEntity<>(symptom, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/findRiskPerson")
    @ResponseBody
    public ResponseEntity<List<RiskPersonDTO>> findRiskPerson(){
        List<RiskPersonDTO> riskPerson = personService.getRiskPersonsList();

        return new ResponseEntity<>(riskPerson, HttpStatus.OK);
    }

}
