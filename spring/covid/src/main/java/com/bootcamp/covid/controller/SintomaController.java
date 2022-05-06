package com.bootcamp.covid.controller;

import com.bootcamp.covid.dto.PacienteDto;
import com.bootcamp.covid.dto.SintomaDto;
import com.bootcamp.covid.service.ISintomaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("app")
public class SintomaController {

    ISintomaService service;

    public SintomaController(ISintomaService service) {
        this.service = service;
    }

    @GetMapping("/symptoms")
    public ResponseEntity<List<SintomaDto>> listSymptoms() {
        return new ResponseEntity<>(service.getSymptoms(), HttpStatus.OK);
    }

    @GetMapping("/symptoms/{name}")
    public ResponseEntity<SintomaDto> getSymptom(@PathVariable String name) {
        return new ResponseEntity<>(service.getSymptomDTO(name), HttpStatus.OK);
    }

    @GetMapping("/risk-people")
    public ResponseEntity<List<PacienteDto>> getRiskPeople() {
        return new ResponseEntity<>(service.getPatients(), HttpStatus.OK);
    }
}
