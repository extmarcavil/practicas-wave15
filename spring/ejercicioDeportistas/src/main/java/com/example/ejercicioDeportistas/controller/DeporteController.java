package com.example.ejercicioDeportistas.controller;

import com.example.ejercicioDeportistas.dto.DeporteDTO;
import com.example.ejercicioDeportistas.dto.DeportistaDTO;
import com.example.ejercicioDeportistas.service.DeporteService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class DeporteController {

    DeporteService service;

    public DeporteController(DeporteService service){
        this.service = service;
    }

    @GetMapping("/findSports")
    public ResponseEntity<ArrayList<DeporteDTO>> getAllDeportes(){
        ArrayList<DeporteDTO> listaDeportes = service.getAllDeportes();
        return new ResponseEntity<>(listaDeportes, HttpStatus.OK);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<DeporteDTO> getDeporteByName(@PathVariable String name){
        DeporteDTO deporteDTO = service.getDeporteByName(name);
        return new ResponseEntity<>(deporteDTO, HttpStatus.OK);
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<ArrayList<DeportistaDTO>> getDeportistas(){
        ArrayList<DeportistaDTO> listaDeportistas = service.getDeportistas();
        return new ResponseEntity<>(listaDeportistas, HttpStatus.OK);
    }

}
