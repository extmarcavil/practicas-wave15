package com.example.hqlmoviesej1.controller;

import com.example.hqlmoviesej1.dto.ActorsDTO;
import com.example.hqlmoviesej1.dto.EpisodesDTO;
import com.example.hqlmoviesej1.service.IActorsService;
import com.example.hqlmoviesej1.service.IEpisodesService;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/episodes")
public class EpisodesController {

    private final IEpisodesService episodesService;

    public EpisodesController(IEpisodesService episodesService) {
        this.episodesService = episodesService;
    }


    @GetMapping("/with-actor")
    ResponseEntity<List<EpisodesDTO>> getEpisodesWithActor(@RequestParam(name = "first-name") String firstName,
                                                                  @RequestParam(name = "last-name") String lastName){
        return ResponseEntity.ok(episodesService.findByActor(firstName, lastName));
    }
}
