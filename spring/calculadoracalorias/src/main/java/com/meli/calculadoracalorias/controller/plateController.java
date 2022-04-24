package com.meli.calculadoracalorias.controller;

import com.meli.calculadoracalorias.dto.plateDTO;
import com.meli.calculadoracalorias.repositories.plateRepository;
import com.meli.calculadoracalorias.services.plateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class plateController {
    @Autowired
    plateService service;

    @GetMapping("/plate")
    public List<plateDTO> obtainPlates () {
        return service.getPlate();
    }
}