package com.meli.moviesHQL.controller;

import com.meli.moviesHQL.model.DTO.ActorDTO;
import com.meli.moviesHQL.model.DTO.ActorMovieResponseDTO;
import com.meli.moviesHQL.service.IActorService;
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
    public List<ActorDTO> getActorByName(@RequestParam String name){
        return service.getActorByName(name);
    }


    /* EJERCICIOS PG */
    @GetMapping("/actorswithfavoritemovie")
    public List<ActorDTO> getActorsWithFavoriteMovie(){
        return service.getActorsWithFavoriteMovie();
    }

    @GetMapping("/actorswithratingmoreas/{rating}")
    public List<ActorDTO> getActorsWithRatingMoreAs(@PathVariable Double rating){
        return service.getActorsWithRatingMoreAs(rating);
    }

    @GetMapping("/actors/{movie}")
    public List<ActorDTO> getActorsThatWorkInMovie(@PathVariable Integer movie){
        return service.getActorsThatWorkInMovie(movie);
    }

    @GetMapping("/actormovie")
    public List<ActorMovieResponseDTO>  getActorWithfavoriteMovie (@RequestParam String name){
        return service.getActorWithfavoriteMovie(name);
    }


}