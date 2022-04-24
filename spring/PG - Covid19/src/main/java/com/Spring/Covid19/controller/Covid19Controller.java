package com.Spring.Covid19.controller;

import com.Spring.Covid19.dto.PersonaSintomaDTO;
import com.Spring.Covid19.model.Sintoma;
import com.Spring.Covid19.dto.SintomaDTO;
import com.Spring.Covid19.repository.ICovid19Repository;
import com.Spring.Covid19.service.ICovid19Service;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Covid19Controller {

    private ICovid19Service service;

    public Covid19Controller(ICovid19Service service) {
        this.service = service;
    }

    @GetMapping("/findSymptom")
    public ResponseEntity<List<SintomaDTO>> listarSintomas(){
        return new ResponseEntity<>(service.listarSintomas(), HttpStatus.OK);
    }

    @GetMapping("/findSymptom/{nombre}")
    public ResponseEntity<SintomaDTO> listarSintomaPorNombre(@PathVariable String nombre){
        return new ResponseEntity<>(service.listarSintomaPorNombre(nombre), HttpStatus.OK);
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<PersonaSintomaDTO>> listarPacientesRiesgo(){
        return new ResponseEntity<>(service.listarSintomaticos(), HttpStatus.OK);
    }
}
