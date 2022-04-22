package com.covid.covid.controller;

import com.covid.covid.dto.PacienteDTO;
import com.covid.covid.dto.SintomaDTO;
import com.covid.covid.servicio.ISintomaServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CovidController {
    ISintomaServicio servicio;

    public CovidController(ISintomaServicio servicio){
        this.servicio = servicio;
    }

    //Punto 1.
    @GetMapping("/symptoms")
    public ResponseEntity<List<SintomaDTO>> listSymptoms () {
        return new ResponseEntity<>(servicio.getListaSintoma(), HttpStatus.OK);
    }

    //Punto 2.
    @GetMapping("/symptoms/{name}")
    public ResponseEntity<SintomaDTO> getSymptom ( @PathVariable String name ) {
        return new ResponseEntity<>(servicio.obtenerSintoma(name), HttpStatus.OK);
    }

    //Punto 3.
    @GetMapping("/risk-people")
    public ResponseEntity<List<PacienteDTO>> getRiskPeople () {
        return new ResponseEntity<>(servicio.obtenerPacientes(), HttpStatus.OK);
    }


}
