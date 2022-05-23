package com.bootcamp.movies.controller;

import com.bootcamp.movies.dto.ActorDTO;
import com.bootcamp.movies.dto.SerieDTO;
import com.bootcamp.movies.service.IActorService;
import com.bootcamp.movies.service.ISerieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/series")
public class SerieController {
    private final ISerieService iSerieService;


    public SerieController(ISerieService iSerieService) {
        this.iSerieService = iSerieService;
    }

    @GetMapping
    @RequestMapping("")
    public ResponseEntity<List<SerieDTO>> getSeriesByCount(@RequestParam("seasons") Integer count) {
        return new ResponseEntity<>(iSerieService.findAllByCount(count), HttpStatus.OK);
    }
}
