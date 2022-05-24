package com.example.hql_movies.controller;

import com.example.hql_movies.dto.ActorsDTO;
import com.example.hql_movies.dto.MoviesDTO;
import com.example.hql_movies.service.IMoviesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MoviesController {
    private final IMoviesService moviesService;

    public MoviesController(IMoviesService moviesService) {
        this.moviesService = moviesService;
    }

    /**
     * Listar todos los actores que trabajan en la <película recibida por parámetro>
     *
     * @return ResponseEntity
     **/
    @GetMapping("/actors")
    public ResponseEntity<List<ActorsDTO>> getActorsOfMovie(@RequestParam String movie){
        return new ResponseEntity<>(moviesService.getActorsByMovie(movie), HttpStatus.OK);
    }

    /**
     * Listar todas las películas cuyos actores tengan rating superior a <valor recibido por parámetro>
     *
     * @return ResponseEntity
     **/
    @GetMapping("/actors_with_rating_greater_than")
    public ResponseEntity<List<MoviesDTO>> getMoviesOfActorsWithRatingGreaterThan(@RequestParam Double rating){
        return new ResponseEntity<>(moviesService.getMoviesOfActorsWithRatingGreaterThan(rating), HttpStatus.OK);
    }

    /**
     * Listar todas las películas que pertenezcan al <género recibido por parámetro>
     *
     * @return ResponseEntity
     **/
    @GetMapping("/genre")
    public ResponseEntity<List<MoviesDTO>> getMoviesWithGenre(@RequestParam String genre){
        return new ResponseEntity(moviesService.getMoviesWithGenre(genre), HttpStatus.OK);
    }
}
