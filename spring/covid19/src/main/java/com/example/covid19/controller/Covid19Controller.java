package com.example.covid19.controller;

import com.example.covid19.DTO.PacienteDTO;
import com.example.covid19.entities.Sintoma;
import com.example.covid19.services.PacientesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Covid19Controller implements ICovid19Controller {

    PacientesService service;

    public Covid19Controller(PacientesService service) {
        this.service = service;
    }

    @Override
    @GetMapping("/findSymptom/all")
    public ResponseEntity<List<Sintoma>> getListadoSintomas() {
        return new ResponseEntity<>(service.getListadoSintomas(), HttpStatus.OK);
    }

    @Override
    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<Sintoma> getSintoma(@PathVariable String name) {
        Sintoma sintoma = service.getSintoma(name);
        if (sintoma == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.status(200).body(sintoma);
    }

    @Override
    @GetMapping("/findRiskPerson/all")
    public ResponseEntity<List<PacienteDTO>> getPacienteRiesgo() {
        return new ResponseEntity<>(service.getListadoPacientesRiesgo(), HttpStatus.OK);
    }
}
