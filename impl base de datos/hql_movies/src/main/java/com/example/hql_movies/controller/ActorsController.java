package com.example.hql_movies.controller;

import com.example.hql_movies.dto.ActorsDTO;
import com.example.hql_movies.service.IActorsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actors")
public class ActorsController {
    private final IActorsService actorsService;

    public ActorsController(IActorsService actorsService) {
        this.actorsService = actorsService;
    }

    /**
     * Listar todos los actores que tengan declarada una película favorita.
     *
     * @return ResponseEntity
     **/
    @GetMapping("/with_favorite_movies")
    public ResponseEntity<List<ActorsDTO>> getActorsWithFavoriteMovies(){
        return new ResponseEntity<>(actorsService.getActorsWithFavoriteMovie(), HttpStatus.OK);
    }

    /**
     * Listar todos los actores que tengan rating superior a <valor recibido por parámetro>.
     *
     * @return ResponseEntity
     **/
    @GetMapping("/with_rating_greater_than")
    public ResponseEntity<List<ActorsDTO>> getActorsWithRatingGreatherThan(@RequestParam Double rating){
        return new ResponseEntity<>(actorsService.getActorsWithRatingGreaterThan(rating), HttpStatus.OK);
    }


}
