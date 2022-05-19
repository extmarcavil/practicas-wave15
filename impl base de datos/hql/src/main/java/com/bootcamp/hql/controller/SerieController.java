package com.bootcamp.hql.controller;

import com.bootcamp.hql.dto.MovieDto;
import com.bootcamp.hql.dto.SerieDto;
import com.bootcamp.hql.service.ISerieService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("series")
public class SerieController {

    private final ISerieService serieService;

    public SerieController(ISerieService serieService){
        this.serieService = serieService;
    }

    //Listar todas las series que tengan más de <cantidad de temporadas recibida por parámetro>
    @GetMapping("/seasons")
    public ResponseEntity<List<SerieDto>> seriesBySeasons(@RequestParam Integer seasons){
        return ResponseEntity.ok().body(serieService.seriesBySeasons(seasons));
    }
}
