package com.example.hql.controller;

import com.example.hql.api.dto.ActorDto;
import com.example.hql.entity.Actor;
import com.example.hql.service.ActorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/actors")
public class ActorController {

    private final ActorService service;

    @GetMapping("/with-favorite-movie")
    public ResponseEntity<List<ActorDto>> getActorsWithFavoriteMovie(){
        return ResponseEntity.ok(
                service.getActorsWithFavoriteMovies()
        );
    }

    @GetMapping("/in-movie/{id_movie}")
    public ResponseEntity<List<ActorDto>> getActorInMovie(@PathVariable("id_movie") Integer idMovie){
        return ResponseEntity.ok(
                service.getActorsInMovie(idMovie)
        );
    }

    @GetMapping
    public ResponseEntity<List<ActorDto>> getActors(@RequestParam(required = false) BigDecimal rating,
                                                    @RequestParam(required = false) String title){
        return ResponseEntity.ok(
                service.getActors(rating,title)
        );
    }

}
