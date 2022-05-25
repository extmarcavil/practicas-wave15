package com.bootcamp.moviesHql.controller;

import com.bootcamp.moviesHql.dto.EpisodeDTO;
import com.bootcamp.moviesHql.service.IEpisodeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/episode")
@RestController
public class EpisodeController {

    IEpisodeService service;

    public EpisodeController(IEpisodeService service) {
        this.service = service;
    }

    @GetMapping("/actor")
    public ResponseEntity<List<EpisodeDTO>> findAllWithActor(@RequestParam String firstName,
                                                             @RequestParam String lastName){
        return ResponseEntity.status(HttpStatus.OK).body(service.findAllEpisode(firstName,lastName));
    }
}
