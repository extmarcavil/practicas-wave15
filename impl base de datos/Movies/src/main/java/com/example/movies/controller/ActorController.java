package com.example.movies.controller;

import com.example.movies.dto.response.ActorsResponseDTO;
import com.example.movies.service.IActorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ActorController {

    private IActorService actorService; 

    public ActorController(IActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping("favMovie")
    public ResponseEntity<List<ActorsResponseDTO>> getActorsWithFavoriteMovie() {
        return ResponseEntity.ok(actorService.findActorsWihtFavoriteMovie());
    }
}
