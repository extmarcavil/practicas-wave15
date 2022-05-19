package com.example.hqlmoviesej1.controller;

import com.example.hqlmoviesej1.dto.ActorsDTO;
import com.example.hqlmoviesej1.service.IActorsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/actors")
public class ActorsController {
    private final IActorsService actorsService;

    public ActorsController(IActorsService actorsService) {
        this.actorsService = actorsService;
    }

    @GetMapping("/with-favourite-movie")
    ResponseEntity<List<ActorsDTO>> getActorsWithFavouriteMovie(){
        return ResponseEntity.ok(actorsService.findByMoviesIsNotNull());
    }

    @GetMapping("/with-rating-greater/{rating}")
    ResponseEntity<List<ActorsDTO>> getActorsWithRatingGreatherThan(@PathVariable Double rating){
        return ResponseEntity.ok(actorsService.findByRatingGreaterThan(rating));
    }

    @GetMapping("/work-movie/{movie}")
    ResponseEntity<List<ActorsDTO>> getActorByMovie(@PathVariable String movie){
        return ResponseEntity.ok(actorsService.findByMovies(movie));
    }
}
