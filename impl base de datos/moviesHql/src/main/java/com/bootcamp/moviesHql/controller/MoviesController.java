package com.bootcamp.moviesHql.controller;

import com.bootcamp.moviesHql.dto.ActorDTO;
import com.bootcamp.moviesHql.dto.MoviesDTO;
import com.bootcamp.moviesHql.service.IMoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MoviesController {

    IMoviesService service;

    @GetMapping("/rating")
    public ResponseEntity<List<MoviesDTO>> getAllMovieActorsRating(@RequestParam Double id){
        return ResponseEntity.ok().body(service.getAllMovieActorsRating(id));
    }
}
