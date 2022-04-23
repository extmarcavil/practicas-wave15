package com.bootcamp.Covid19.controller;


import com.bootcamp.Covid19.dto.PersonDTO;
import com.bootcamp.Covid19.dto.SymptomDTO;
import com.bootcamp.Covid19.service.IPersonaService;
import com.bootcamp.Covid19.service.ISymptomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SymptomController {

    ISymptomService service_symptom;
    IPersonaService service_persona;

    public SymptomController (ISymptomService service_symptom, IPersonaService service_persona) {
        this.service_symptom = service_symptom;
        this.service_persona = service_persona;
    }

    @GetMapping("/findSymptoms")
    public ResponseEntity<List<SymptomDTO>> getSymptoms(){
        return new ResponseEntity<>(service_symptom.get_symptomsDTO(), HttpStatus.OK);
    }

    @GetMapping("/findSymptoms/{name}")
    public ResponseEntity<SymptomDTO> getSymptomByName(@PathVariable String name){
        return new ResponseEntity<>(service_symptom.get_symptomByNameDTO(name),HttpStatus.OK);
    }

    @GetMapping("/riskPeople")
    public ResponseEntity<List<PersonDTO>> getRiskPeople(){
        return new ResponseEntity<>(service_persona.get_riskPeopleDTO(),HttpStatus.OK);
    }
}
