package ar.com.mercadolibre.bootcamp.lfedele.hqlmoviesdb.controller;

import ar.com.mercadolibre.bootcamp.lfedele.hqlmoviesdb.dto.SerieDto;
import ar.com.mercadolibre.bootcamp.lfedele.hqlmoviesdb.service.SerieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/hql/serie")
public class ServiceController {
    private final SerieService serieService;

    public ServiceController(SerieService serieService){
        this.serieService=serieService;
    }
    
    @GetMapping
    public ResponseEntity<List<SerieDto>> findAll() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(serieService.findAll());
    }

    @GetMapping("/seasons")
    public ResponseEntity<List<SerieDto>> findAllWithMoreSeasonsThan(@RequestParam Integer seasons) {
        return ResponseEntity.ok(serieService.findAllWithMoreSeasonsThan(seasons));
    }
}
