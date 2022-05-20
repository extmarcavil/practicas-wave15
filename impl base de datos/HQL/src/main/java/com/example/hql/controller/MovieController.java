package com.example.hql.controller;

import com.example.hql.api.dto.MovieDto;
import com.example.hql.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService service;

    @RequestMapping
    ResponseEntity<List<MovieDto>> getMovies(
            @RequestParam(value = "rating",required = false) BigDecimal rating,
            @RequestParam(value = "genre",required = false) String genre
            ){
        return ResponseEntity.ok(service.getMovies(rating,genre));

    }
}
