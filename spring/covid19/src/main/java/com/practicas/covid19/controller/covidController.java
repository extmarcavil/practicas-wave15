package com.practicas.covid19.controller;

import com.practicas.covid19.dto.PersonaDTO;
import com.practicas.covid19.dto.SintomaDTO;
import com.practicas.covid19.model.Sintoma;
import com.practicas.covid19.service.PersonasDTOService;
import com.practicas.covid19.service.SintomasService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class covidController {
    @GetMapping("findSymptom")
    public ResponseEntity<List<SintomaDTO>>  getSintomas(){
        return new ResponseEntity<List<SintomaDTO>>(SintomasService.obtenerSintomasDTO(), HttpStatus.OK);
    }

    @GetMapping("findSymptom/{name}")
    public ResponseEntity<String> buscarSintoma(@PathVariable String name){
        return new ResponseEntity<>(SintomasService.buscarSintoma(name), HttpStatus.ACCEPTED);
    }

    @GetMapping("findRiskPerson")
    public List<PersonaDTO> getPersonasEnRiesgo(){
        return PersonasDTOService.getPersonasDTO();
    }
}
