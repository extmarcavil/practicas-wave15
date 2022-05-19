package com.bootcamp.movies.controller;

import com.bootcamp.movies.dto.RespEpisodeDTO;
import com.bootcamp.movies.service.EpisodeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/episodes")
public class EpisodeController {
    private final EpisodeService episodeService;

    public EpisodeController(EpisodeService episodeService) {
        this.episodeService = episodeService;
    }

    @GetMapping
    @RequestMapping("/actor")
    public ResponseEntity<List<RespEpisodeDTO>> getAllEpisodesByActorByFirstNameAndLastName(@RequestParam("first_name") String firstName, @RequestParam("last_name") String lastName) {
        return new ResponseEntity<>(episodeService.getAllEpisodesByActorByFirstNameAndLastName(firstName,lastName), HttpStatus.OK);
    }
}
