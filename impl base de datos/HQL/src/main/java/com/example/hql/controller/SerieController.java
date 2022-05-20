package com.example.hql.controller;

import com.example.hql.api.dto.SeriesDto;
import com.example.hql.service.SerieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/series")
@RequiredArgsConstructor
public class SerieController {

    private final SerieService service;

    @GetMapping
    public ResponseEntity<List<SeriesDto>> getSeries(@RequestParam(required = false)  Long cant){
        return ResponseEntity.ok(service.getSeries(cant));
    }
}
