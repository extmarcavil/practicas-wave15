package com.example.hqlmoviesej1.controller;

import com.example.hqlmoviesej1.dto.MoviesDTO;
import com.example.hqlmoviesej1.dto.SeriesDTO;
import com.example.hqlmoviesej1.service.IActorsService;
import com.example.hqlmoviesej1.service.ISeriesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/series")
public class SeriesController {

    private final ISeriesService seriesService;

    public SeriesController(ISeriesService seriesService) {
        this.seriesService = seriesService;
    }

    @GetMapping("/with-seasons-amount-greater/{amount}")
    ResponseEntity<List<SeriesDTO>> getSeriesWithSeasonsAmountGreaterThan(@PathVariable Integer amount){
        return ResponseEntity.ok(seriesService.findBySeasonsAmountGreatherThan(amount));
    }
}
