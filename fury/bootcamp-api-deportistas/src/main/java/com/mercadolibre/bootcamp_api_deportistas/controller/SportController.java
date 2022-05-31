package com.mercadolibre.bootcamp_api_deportistas.controller;

import com.mercadolibre.bootcamp_api_deportistas.entity.Sport;
import com.mercadolibre.bootcamp_api_deportistas.service.SportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class SportController {
    private final SportService sportService;

    @GetMapping("/findSports")
    public List<Sport> findSports() {
        return sportService.findSports();
    }
    @GetMapping("/findSports/{sportName}")
    public Sport findSport(@PathVariable String sportName) {
        return sportService.findSport(sportName);
    }
}
