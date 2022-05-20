package com.bootcamp.moviesHql.controller;


import com.bootcamp.moviesHql.dto.ActorDto;
import com.bootcamp.moviesHql.model.Actors;
import com.bootcamp.moviesHql.service.IActorsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/actors")
@RestController
public class ActorsController {

    IActorsService service;

    public ActorsController(IActorsService service) {
        this.service = service;
    }

    //http://localhost:8080/actors/favorite
    @GetMapping("/favorite")
    public ResponseEntity<List<ActorDto>> getAllFavorite(){
        return ResponseEntity.ok().body(service.getAllFavorite());
    }

    //http://localhost:8080/actors/rating?rating=7.4
    @GetMapping("/rating")
    public ResponseEntity<List<ActorDto>> getAllRating(@RequestParam Double rating){
        return ResponseEntity.ok().body(service.getAllRating(rating));
    }

    //http://localhost:8080/actors/movie?title=Avatar
    @GetMapping("/movie")
    public ResponseEntity<List<ActorDto>> getAllActorsMovie(@RequestParam String title){
        return ResponseEntity.ok().body(service.getAllActorsMovie(title));
    }

}
