package com.spring.ejerciciocalculadoracalorias.controller;

import com.spring.ejerciciocalculadoracalorias.dto.InfoPlatoDTO;
import com.spring.ejerciciocalculadoracalorias.dto.IngredienteDTO;
import com.spring.ejerciciocalculadoracalorias.dto.PlatoDTO;
import com.spring.ejerciciocalculadoracalorias.service.FoodService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FoodController {

    private final FoodService service;


    public FoodController(FoodService service) {
        this.service = service;
    }

    @GetMapping("{nombrePlato}/{peso}")
    public ResponseEntity<InfoPlatoDTO> getInfoPlato(
            @RequestBody List<IngredienteDTO> ingredientes,
            @PathVariable String nombrePlato,
            @PathVariable Double peso) {

        return new ResponseEntity<>(service
                .getInfoPlato(
                        new PlatoDTO(nombrePlato, ingredientes),
                        peso),
                HttpStatus.OK);
    }
}
