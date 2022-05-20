package com.example.hql.controller;

import com.example.hql.api.dto.EpisodeDto;
import com.example.hql.service.EpisodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/episodes")
public class EpisodeController {

    private final EpisodeService service;

    @GetMapping
    public ResponseEntity<List<EpisodeDto>> getEpisodes(@RequestParam String name){
        return ResponseEntity.ok(service.getEpisodesByActor(name));
    }
}
