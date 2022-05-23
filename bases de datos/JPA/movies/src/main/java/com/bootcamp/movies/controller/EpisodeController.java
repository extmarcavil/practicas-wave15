package com.bootcamp.movies.controller;

import com.bootcamp.movies.dto.ActorDTO;
import com.bootcamp.movies.dto.EpisodeDTO;
import com.bootcamp.movies.service.IActorService;
import com.bootcamp.movies.service.IEpisodeService;
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

    private final IEpisodeService iEpisodeService;


    public EpisodeController(IEpisodeService iEpisodeService) {
        this.iEpisodeService = iEpisodeService;
    }

    @GetMapping
    @RequestMapping("/actorWorking")
    public ResponseEntity<List<EpisodeDTO>> getEpisodesParam(@RequestParam Long idActor ) {
        return new ResponseEntity<>(iEpisodeService.getAllEpisodes(idActor), HttpStatus.OK);
    }
}