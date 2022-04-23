package com.Spring.Deportistas.controller;

import com.Spring.Deportistas.dto.DeporteDTO;
import com.Spring.Deportistas.dto.PersonaDeportistaDTO;
import com.Spring.Deportistas.model.Deporte;
import com.Spring.Deportistas.service.IDeporteService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

    IDeporteService service;

    public Controller (IDeporteService service){
        this.service = service;
    }

    @GetMapping("/findSports")
    public ResponseEntity<List<DeporteDTO>> findSports() {
        return new ResponseEntity<>(service.listarDeportes(), HttpStatus.OK);
    }

    @GetMapping("/sports/{nombre}")
    public ResponseEntity<DeporteDTO> listarDeportePorNombre(@PathVariable String nombre){
        return new ResponseEntity<>(service.listarDeporteDTO(nombre), HttpStatus.OK);
    }

    @GetMapping("/deportistas")
    public ResponseEntity<List<PersonaDeportistaDTO>> listarDeportistas(){
        return new ResponseEntity<>(service.listarDeportistas(), HttpStatus.OK);
    }


    
    
}
