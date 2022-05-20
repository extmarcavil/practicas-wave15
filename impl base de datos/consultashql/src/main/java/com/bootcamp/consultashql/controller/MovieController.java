package com.bootcamp.consultashql.controller;

import com.bootcamp.consultashql.dto.ActorDTO;
import com.bootcamp.consultashql.dto.MovieDTO;
import com.bootcamp.consultashql.service.IMoviesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private IMoviesService service;

    public MovieController(IMoviesService service) {
        this.service = service;
    }

    @GetMapping("/rating")
    public List<MovieDTO> getMoviesByActorsWithRatingGreaterThan(@RequestParam Double rating){
        return service.getMoviesByActorsWithRatingGreaterThan(rating);
    }

    @GetMapping("/genre")
    public List<MovieDTO> getMoviesOfGenre(@RequestParam String genre){
        return service.getMoviesByGenre(genre);
    }

}
