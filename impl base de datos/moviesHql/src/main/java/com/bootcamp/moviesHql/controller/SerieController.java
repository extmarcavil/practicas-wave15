package com.bootcamp.moviesHql.controller;

import com.bootcamp.moviesHql.dto.SerieDTO;
import com.bootcamp.moviesHql.service.ISerieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/serie")
@RestController
public class SerieController {

    ISerieService service;

    public SerieController(ISerieService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<SerieDTO>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

    @GetMapping("/seasons")
    public ResponseEntity<List<SerieDTO>> findAllWithMoreSeasonsThan(@RequestParam Integer seasons) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAllSerie(seasons));
    }
}
