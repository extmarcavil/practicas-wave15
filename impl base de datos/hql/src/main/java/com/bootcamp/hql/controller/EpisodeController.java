package com.bootcamp.hql.controller;

import com.bootcamp.hql.dto.EpisodeDto;
import com.bootcamp.hql.service.IEpisodeService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("episodes")
public class EpisodeController {

    private IEpisodeService episodeService;

    public EpisodeController(IEpisodeService episodeService) {
        this.episodeService = episodeService;
    }

    //Listar todos los episodios (de cualquier serie) donde trabaja un <actor recibido por parámetro>
    @GetMapping("/actor")
    public ResponseEntity<List<EpisodeDto>> episodesByActors(@RequestParam String actor){
        return ResponseEntity.ok().body(episodeService.episodesByActors(actor));
    }
}
