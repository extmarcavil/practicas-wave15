package com.bootcamp.consultashql.controller;

import com.bootcamp.consultashql.dto.ActorDTO;
import com.bootcamp.consultashql.service.IActorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/actors")
public class ActorController {

    private IActorService service;

    public ActorController(IActorService service) {
        this.service = service;
    }

    @GetMapping("/favorite-movie")
    public List<ActorDTO> getActorsWithFavoriteMovie(){
        return service.getActorsWithFavoriteMovie();
    }

    @GetMapping("/rating")
    public List<ActorDTO> getActorsWithRatingGreaterThan(@RequestParam Double rating){
        return service.getActorsWithRatingGreaterThan(rating);
    }

    @GetMapping("/movie")
    public List<ActorDTO> getActorsOfMovie(@RequestParam String movie) {
        return service.getActorsOfMovie(movie);
    }

}
