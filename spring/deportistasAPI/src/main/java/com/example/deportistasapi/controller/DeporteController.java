package com.example.deportistasapi.controller;

import com.example.deportistasapi.model.Deporte;
import com.example.deportistasapi.service.IDeporteService;
import com.example.deportistasapi.service.IPersonaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeporteController {

    private IDeporteService deporteService;

    public DeporteController(IDeporteService deporteService) {
        this.deporteService = deporteService;
    }

    @GetMapping("/findSports")
    public List<Deporte> findSport() {
        return this.deporteService.findAllSports();
    }

    @GetMapping("findSport/{name}")
    public ResponseEntity<Deporte> findSportByName(@PathVariable String name) {
        return this.deporteService.findSportByName(name)
                .map(deporte -> new ResponseEntity<>(deporte, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }
}