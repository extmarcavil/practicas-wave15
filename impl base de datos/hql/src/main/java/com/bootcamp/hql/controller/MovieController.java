package com.bootcamp.hql.controller;

import com.bootcamp.hql.dto.ActorDto;
import com.bootcamp.hql.dto.MovieDto;
import com.bootcamp.hql.service.IMovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("movies")
public class MovieController {

    private IMovieService movieService;

    public MovieController(IMovieService movieService){
        this.movieService = movieService;
    }

    //Listar todas las películas cuyos actores tengan rating superior a <valor recibido por parámetro>
    @GetMapping("/rating")
    public ResponseEntity<List<MovieDto>> moviesByActorsRating(@RequestParam BigDecimal rating){
        return ResponseEntity.ok().body(movieService.moviesByActorsRating(rating));
    }

    //Listar todas las películas que pertenezcan al <género recibido por parámetro>
    @GetMapping("/genre")
    public ResponseEntity<List<MovieDto>> moviesByGenre(@RequestParam String genre){
        return ResponseEntity.ok().body(movieService.moviesByGenre(genre));
    }
}
