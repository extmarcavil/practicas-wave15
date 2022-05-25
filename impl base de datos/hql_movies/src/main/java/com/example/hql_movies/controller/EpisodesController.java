package com.example.hql_movies.controller;

import com.example.hql_movies.dto.EpisodesDTO;
import com.example.hql_movies.service.IEpisodesService;
import org.springframework.http.HttpStatus;
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

    /**
     * Listar todos los episodios (de cualquier serie) donde trabaja un <actor recibido por parámetro>
     *
     * @return ResponseEntity
     **/
    @GetMapping("/with_actor")
    public ResponseEntity<List<EpisodesDTO>> getEpisodesWithActor(
            @RequestParam String firstName,
            @RequestParam String lastName){
        return new ResponseEntity<>(episodesService.getEpisodesWithActor(firstName, lastName), HttpStatus.OK);
    }


}
