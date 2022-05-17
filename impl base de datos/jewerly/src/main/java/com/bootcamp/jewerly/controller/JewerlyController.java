package com.bootcamp.jewerly.controller;

import com.bootcamp.jewerly.service.IJewerlyService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JewerlyController {

    private final IJewerlyService jewerlyService;

    public JewerlyController(IJewerlyService jewerlyService) {
        this.jewerlyService = jewerlyService;
    }

}
