package ar.com.mercadolibre.bootcamp.lfedele.hqlmoviesdb.controller;

import ar.com.mercadolibre.bootcamp.lfedele.hqlmoviesdb.dto.ActorDto;
import ar.com.mercadolibre.bootcamp.lfedele.hqlmoviesdb.service.ActorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/hql/actor")
public class ActorController {
    private final ActorService actorService;

    public ActorController(ActorService actorService){
        this.actorService=actorService;
    }

    @GetMapping
    public ResponseEntity<List<ActorDto>> findAll() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(actorService.findAll());
    }

    @GetMapping("/favmovies")
    public ResponseEntity<List<ActorDto>> findAllWithFavoriteMovies() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(actorService.findAllByFavoriteMovieNotNull_Hql());
    }

    @GetMapping("/ratinggreaterthan/{rating}")
    public ResponseEntity<List<ActorDto>> findAllWithFavoriteMovies(@PathVariable Integer rating) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(actorService.findAllByRatingGreaterThan_Hql(rating));
    }

    @GetMapping("/workedin/{movieName}")
    public ResponseEntity<List<ActorDto>> findAllWhoWorkedIn(@PathVariable String movieName) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(actorService.findAllWhoWorkedInMovie(movieName));
    }
}
