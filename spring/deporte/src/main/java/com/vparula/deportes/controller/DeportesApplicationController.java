package com.vparula.deportes.controller;


import com.vparula.deportes.dtos.DeporteDTO;
import com.vparula.deportes.dtos.PersonaDTO;
import com.vparula.deportes.service.IDeportistasService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class DeportesApplicationController {
    IDeportistasService servicio;

    public DeportesApplicationController (  IDeportistasService servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/findSport")
    public ResponseEntity<List<DeporteDTO>> getDeportes () {
        return new ResponseEntity<>(servicio.getDeportes(), HttpStatus.OK);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<DeporteDTO> getDeportesPorNombre ( @PathVariable String name ) {
        return new ResponseEntity<>(servicio.getDeportesPorNombre(name), HttpStatus.OK);
    }

    @GetMapping("/findSportsPerson")
    public ResponseEntity<List<PersonaDTO>> getDeportistas () {
        return new ResponseEntity<>(servicio.getDeportistas(), HttpStatus.OK);
    }
}
