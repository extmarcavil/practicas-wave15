package com.bootcamp.consultashql.controller;

import com.bootcamp.consultashql.dto.MovieDTO;
import com.bootcamp.consultashql.dto.SerieDTO;
import com.bootcamp.consultashql.repository.ISerieRepository;
import com.bootcamp.consultashql.service.ISerieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/series")
public class SerieController {

    private ISerieService service;

    public SerieController(ISerieService service) {
        this.service = service;
    }

    @GetMapping("/seasons")
    public List<SerieDTO> findSeriesByAmountSeasonsGreaterThan(@RequestParam Long seasons){
        return service.findSeriesByAmountSeasonsGreaterThan(seasons);
    }
}
