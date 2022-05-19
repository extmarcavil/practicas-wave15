package com.movies.demoHQL.controller;

import com.movies.demoHQL.DTO.ActorDTO;
import com.movies.demoHQL.DTO.ActorMovieResponseDTO;
import com.movies.demoHQL.service.IActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ActorsController {

    @Autowired
    IActorService service;

    @GetMapping("/actors")
    public List<ActorDTO> getActors(){
        return service.getAllActors();
    }

    @GetMapping("/actorbyname")
    public ActorDTO getActorByName(@RequestParam String name){
        return service.getActorByName(name);
    }

    @GetMapping("/actormovie")
    public ActorMovieResponseDTO getActorWithfavoriteMovie (@RequestParam String name){

        return service.getActorWithfavoriteMovie(name);
    }

    @GetMapping("/actorsfavorites")
    public List<ActorMovieResponseDTO> getActorsWithFavoritesMovies(){
        return service.getActorsWithFavoriteMovies();
    }

    @GetMapping("/actorsrating/{rating}")
    public List<ActorMovieResponseDTO> getActorsByRating(@PathVariable Double rating){
        return service.getActorsByRating(rating);
    }

    @GetMapping("/actorsOfMovie/{movie}")
    public List<ActorMovieResponseDTO> getActorsOfMovie (@PathVariable String movie) {
        return service.getActorsOfMovie(movie);
    }
}
