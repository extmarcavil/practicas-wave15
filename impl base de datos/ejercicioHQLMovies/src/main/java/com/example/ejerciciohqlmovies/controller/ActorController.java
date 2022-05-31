package com.example.ejerciciohqlmovies.controller;

import com.example.ejerciciohqlmovies.dto.ActorDTO;
import com.example.ejerciciohqlmovies.service.IActorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ActorController {
    private final IActorService actorService;

    public ActorController(IActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping("/actorsWithFavoriteMovie")
    public ResponseEntity<List<ActorDTO>> getActorsWithFavoriteMovie() {
        return new ResponseEntity<>(actorService.findActorsWithFavouriteMovie(), HttpStatus.OK);
    }
}
