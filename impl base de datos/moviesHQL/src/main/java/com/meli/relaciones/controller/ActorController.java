package com.meli.relaciones.controller;

import com.meli.relaciones.entities.Actor;
import com.meli.relaciones.entities.Movie;
import com.meli.relaciones.repository.ActorRepository;
import com.meli.relaciones.service.IMoviesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ActorController {
    ActorRepository service;

    public ActorController(ActorRepository service) {
        this.service = service;
    }

    @GetMapping("/actors/{movie_id}")
    public ResponseEntity<List<Actor>> findMoviesWithActorByRating(@PathVariable Long movie_id) {
        return ResponseEntity.ok(service.findActorsInMovie(movie_id));
    }
}
