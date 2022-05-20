package com.movies.movies.controller;

import com.movies.movies.model.Actor;
import com.movies.movies.model.Movie;
import com.movies.movies.service.IActorsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("actors")
public class ActorsController {
    IActorsService actorsService;
    public ActorsController(IActorsService actorsService){
        this.actorsService=actorsService;
    }
    @GetMapping("/getAllFav")
    public ResponseEntity<List<Actor>> getAllFav(){
        return ResponseEntity.ok().body(actorsService.getAllFav());
    }
}
