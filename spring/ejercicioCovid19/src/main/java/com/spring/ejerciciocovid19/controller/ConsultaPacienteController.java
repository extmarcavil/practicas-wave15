package com.spring.ejerciciocovid19.controller;

import com.spring.ejerciciocovid19.dtos.SintomaDTO;
import com.spring.ejerciciocovid19.service.ISintomaService;
import com.spring.ejerciciocovid19.service.SintomaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConsultaPacienteController {

    ISintomaService service;

    public ConsultaPacienteController(ISintomaService service) {
        this.service = service;
    }


    @GetMapping("{sintomas}")
    public ResponseEntity<List<SintomaDTO>> listSintomas() {
        return new ResponseEntity<>(service.getAllSintomas(), HttpStatus.OK);
    }

    @GetMapping("sintomas/{name}")
    public ResponseEntity<SintomaDTO> getSintoma(@PathVariable String name) {
        return new ResponseEntity<SintomaDTO>(service.getSintoma(name), HttpStatus.OK);
    }


}
