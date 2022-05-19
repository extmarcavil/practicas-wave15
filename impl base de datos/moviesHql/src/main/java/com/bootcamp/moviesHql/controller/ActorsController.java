package com.bootcamp.moviesHql.controller;


import com.bootcamp.moviesHql.dto.ActorDTO;
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

    @GetMapping("/favorite")
    public ResponseEntity<List<Actors>> getAllFavorite(){
        return ResponseEntity.ok().body(service.getAllFavorite());
    }

    @GetMapping("/rating")
    public ResponseEntity<List<Actors>> getAllRating(@RequestParam Double rating){
        return ResponseEntity.ok().body(service.getAllRating(rating));
    }

    @GetMapping("/movie")
    public ResponseEntity<List<ActorDTO>> getAllActorsMovie(@RequestParam Integer id){
        return ResponseEntity.ok().body(service.getAllActorsMovie(id));
    }

}
