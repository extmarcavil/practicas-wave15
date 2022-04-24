package com.covid19.covid19.controller;

import com.covid19.covid19.dto.SintomaDTO;
import com.covid19.covid19.dto.SintomasDTO;
import com.covid19.covid19.model.Paciente;
import com.covid19.covid19.model.Sintoma;
import com.covid19.covid19.repository.Pacientes;
import com.covid19.covid19.repository.Sintomas;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
public class Covid19Controller {
    Sintomas sintomas;
    Pacientes pacientes;

    public Covid19Controller() {
        sintomas = new Sintomas();
        pacientes = new Pacientes();
    }

    @GetMapping("/findSymptom")
    public ResponseEntity<SintomasDTO> sintomas (){
        return new ResponseEntity<>(new SintomasDTO(sintomas.getSintomas()), HttpStatus.ACCEPTED);
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<SintomaDTO> sintomasNombre (@PathVariable String name){
        Optional<Sintoma> sintoma = sintomas.buscarSintoma(name);
        return new ResponseEntity<>(new SintomaDTO(sintoma.get()), HttpStatus.ACCEPTED);
    }
    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<Paciente>> pacientesEnRiesgo(){
        return new ResponseEntity<>(pacientes.pacientesMayores60(),HttpStatus.ACCEPTED);
    }




}
