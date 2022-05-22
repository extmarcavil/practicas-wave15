package ar.com.mercadolibre.bootcamp.lfedele.hqlmoviesdb.controller;

import ar.com.mercadolibre.bootcamp.lfedele.hqlmoviesdb.dto.EpisodeDto;
import ar.com.mercadolibre.bootcamp.lfedele.hqlmoviesdb.service.EpisodeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/hql/episode")
public class EpisodeController {
    private final EpisodeService service;

    public EpisodeController(EpisodeService service) {
        this.service = service;
    }

    @GetMapping("/actor")
    public ResponseEntity<List<EpisodeDto>> findAllWithActor(
            @RequestParam String firstName,
            @RequestParam String lastName)
    {
        return ResponseEntity.ok(service.findAllWithActor(firstName,lastName));
    }
}
