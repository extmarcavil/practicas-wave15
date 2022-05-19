package com.bootcamp.movies.controller;

import com.bootcamp.movies.dto.RespSerieDTO;
import com.bootcamp.movies.service.SerieService;
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
    private final SerieService serieService;

    public SerieController(SerieService serieService) {
        this.serieService = serieService;
    }

    @GetMapping
    @RequestMapping("/seasons")
    public ResponseEntity<List<RespSerieDTO>> getAllSeriesByAmountSeasonsIsGreaterThan(@RequestParam("amount_greater_than") Long amount) {
        return new ResponseEntity<>(serieService.getAllSeriesByAmountSeasonsIsGreaterThan(amount), HttpStatus.OK);
    }
}
