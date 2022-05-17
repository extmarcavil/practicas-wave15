package com.example.demoORM.controller;

import com.example.demoORM.model.MiniSerie;
import com.example.demoORM.service.IMiniSerieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MiniSerieController {

    private IMiniSerieService service;

    public MiniSerieController(IMiniSerieService service) {
        this.service = service;
    }

    @GetMapping("/getminiseries")
    public ResponseEntity<List<MiniSerie>> getAllMiniSeries () {
        return new ResponseEntity<>(service.getMiniSeries(), HttpStatus.OK);
    }

    @PostMapping("/saveminiserie")
    public ResponseEntity<MiniSerie> saveMiniSerie (@RequestBody MiniSerie serie) {
        service.saveMiniSerie(serie);
        return new ResponseEntity<>(serie, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteminiserie/{id}")
    public String deleteSerie (@PathVariable Long id) {
        service.deleteMiniSerie(id);
        return "The mini series has been deleted succesfully";
    }

    @GetMapping("/findminiserie/{id}")
    public ResponseEntity<MiniSerie> findSerieById (@PathVariable Long id) {
        return new ResponseEntity<>(service.findSerie(id), HttpStatus.OK);
    }


}
