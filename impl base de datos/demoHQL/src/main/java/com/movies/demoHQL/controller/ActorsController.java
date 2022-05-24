package com.movies.demoHQL.controller;

import com.movies.demoHQL.model.DTO.ActorDTO;
import com.movies.demoHQL.model.DTO.MovieDTO;
import com.movies.demoHQL.model.DTO.ActorMovieResponceDTO;
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
    public ActorMovieResponceDTO getActorWithfavoriteMovie (@RequestParam String name){

        return service.getActorWithfavoriteMovie(name);
    }

    @GetMapping("/actorsfavorites")
    public List<ActorMovieResponceDTO> getActorsWithFavoritesMovies(){
        return service.getActorsWithFavoriteMovies();
    }

    @GetMapping("/actorsrating/{rating}")
    public List<ActorMovieResponceDTO> getActorsByRating(@PathVariable Double rating){
        return service.getActorsByRating(rating);
    }

    @GetMapping("/actor/worksat/{id}")
    public List<ActorMovieResponceDTO> getActorsOfMovie(@PathVariable Integer id){
        return service.getActorsOfMovie(id);
    }



}
