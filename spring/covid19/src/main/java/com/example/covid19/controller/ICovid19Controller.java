package com.example.covid19.controller;

import com.example.covid19.DTO.PacienteDTO;
import com.example.covid19.entities.Sintoma;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ICovid19Controller {

    ResponseEntity<List<Sintoma>> getListadoSintomas();

    ResponseEntity<Sintoma> getSintoma(@PathVariable String name);

    ResponseEntity<List<PacienteDTO>> getPacienteRiesgo();

}
