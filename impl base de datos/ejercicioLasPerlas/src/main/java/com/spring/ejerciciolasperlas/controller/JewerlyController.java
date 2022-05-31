package com.spring.ejerciciolasperlas.controller;

import com.spring.ejerciciolasperlas.model.Jewerly;
import com.spring.ejerciciolasperlas.service.IJewerlyService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JewerlyController {
    private final IJewerlyService jewerlyService;

    public JewerlyController(IJewerlyService jewerlyService) {
        this.jewerlyService = jewerlyService;
    }

    //CREATE
    @PostMapping("/jewerly/new")
    public String createJewerly(@RequestBody Jewerly jewerly) {
        jewerlyService.createJewerly(jewerly);
        return "La joya fue guardada correctamente";
    }

    //READ all
    
}
