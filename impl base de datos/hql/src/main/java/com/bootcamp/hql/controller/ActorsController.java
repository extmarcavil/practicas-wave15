package com.bootcamp.hql.controller;

import com.bootcamp.hql.dto.ActorDto;
import com.bootcamp.hql.service.IActorService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("actors")
public class ActorsController {

    private final IActorService actorsService;

    public ActorsController(IActorService actorsService){
        this.actorsService = actorsService;
    }

    @GetMapping
    public ResponseEntity<List<ActorDto>> getAll(){
        return ResponseEntity.ok().body(actorsService.getAll());
    }

    @GetMapping("/withFavoriteMovie")
    public ResponseEntity<List<ActorDto>> getAllActorsWithFavoriteMovie(){
        return ResponseEntity.ok().body(actorsService.getAllActorsWithFavoriteMovie());
    }

    //Listar todos los actores que tengan rating superior a <valor recibido por parámetro>
    @GetMapping("/rating")
    public ResponseEntity<List<ActorDto>> actorsByRating(@RequestParam BigDecimal rating){
        return ResponseEntity.ok().body(actorsService.actorsByRating(rating));
    }

    //Listar todos los actores que trabajan en la <película recibida por parámetro>
    @GetMapping("/movie")
    public ResponseEntity<List<ActorDto>> actorsByMovie(@RequestParam String movie){
        return ResponseEntity.ok().body(actorsService.actorsByMovie(movie));
    }

}
