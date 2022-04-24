package com.example.EjercicioCovid.controller;

import com.example.EjercicioCovid.dto.PacienteDTO;
import com.example.EjercicioCovid.dto.SintomaDTO;
import com.example.EjercicioCovid.model.Sintoma;
import com.example.EjercicioCovid.service.SintomaServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CovidController {

    SintomaServicio servicio;

    public CovidController(SintomaServicio servicio){
        this.servicio = servicio;
    }

    @GetMapping("/findSymptom")
    public ResponseEntity<ArrayList<SintomaDTO>> getSintomas(){
        ArrayList<SintomaDTO> listaSintomas = servicio.getSintomasDTO();
        return new ResponseEntity<>(listaSintomas, HttpStatus.OK);
    }

    @GetMapping("/findSymptom/{nombre}")
    public ResponseEntity<SintomaDTO> getSintoma(@PathVariable String nombre){
        SintomaDTO sintomaDto = servicio.getSintomaByName(nombre);
        return new ResponseEntity<>(sintomaDto, HttpStatus.OK);
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<PacienteDTO>> getPacientesRiesgo(){
        List<PacienteDTO> listaPacientesRiesgo = servicio.getPacientesRiesgo();
        return new ResponseEntity<>(listaPacientesRiesgo, HttpStatus.OK);
    }




}
