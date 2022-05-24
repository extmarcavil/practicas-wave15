package com.example.hql_movies.controller;

import com.example.hql_movies.dto.SeriesDTO;
import com.example.hql_movies.service.ISeriesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/series")
public class SeriesController {

    private final ISeriesService seriesService;

    public SeriesController(ISeriesService seriesService) {
        this.seriesService = seriesService;
    }

    /**
     * Listar todas las series que tengan más de <cantidad de temporadas recibida por parámetro>
     *
     * @return ResponseEntity
     **/
    @GetMapping("/with_seasons_greater")
    public ResponseEntity<List<SeriesDTO>> getSeriesWithSeasonsAmountGreaterThan(@RequestParam Integer seasons){
        return new ResponseEntity<>(seriesService.getSeriesWithSeasonsAmountGreaterThan(seasons), HttpStatus.OK);
    }


}
