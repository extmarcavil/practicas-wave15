package ar.com.mercadolibre.bootcamp.lfedele.hqlmoviesdb.controller;

import ar.com.mercadolibre.bootcamp.lfedele.hqlmoviesdb.dto.MovieDto;
import ar.com.mercadolibre.bootcamp.lfedele.hqlmoviesdb.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/hql/movie")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService){
        this.movieService=movieService;
    }

    @GetMapping("/withactorsrating/{rating}")
    public ResponseEntity<List<MovieDto>> findAllWithActorsRatingGreaterThan(@PathVariable Integer rating){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(movieService.findAllWithActorsRatingGreaterThan(rating));
    }

    @GetMapping("/withgenre/{genre}")
    public ResponseEntity<List<MovieDto>> findAllWithGenre(@PathVariable String genre) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(movieService.findAllWithGenre(genre));
    }
}
