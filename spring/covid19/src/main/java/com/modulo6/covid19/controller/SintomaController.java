package com.modulo6.covid19.controller;

import com.modulo6.covid19.model.PacienteDTO;
import com.modulo6.covid19.model.SintomaDTO;
import com.modulo6.covid19.service.PersonaService;
import com.modulo6.covid19.service.SintomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/findSymtom")
public class SintomaController {

    @Autowired
    SintomaService sintomaService;
    @Autowired
    PersonaService personaService;

    //consulta postman: http://localhost:8080/findSymtom/
    @GetMapping("/")
    public List<SintomaDTO> getSintomas(){

        return sintomaService.getSintomas();
    }


    //consulta postman: http://localhost:8080/findSymtom/sintoma/{tos}
    @GetMapping("/sintoma/{name}")
    public ResponseEntity<SintomaDTO> getSintomasNombre(@PathVariable String name){

       return new ResponseEntity<>(sintomaService.getSintomaNombre(name), HttpStatus.OK);
    }

    //consulta postman: http://localhost:8080/findSymtom/findRiskPerson
    @GetMapping("/findRiskPerson")
    public ResponseEntity <List<PacienteDTO>> getSintomasNombre(){

        return new ResponseEntity<>(personaService.getPacientesMayores(), HttpStatus.OK);
    }

}
