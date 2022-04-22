package com.ejercicio.calculadoracalorias.controller;

import com.ejercicio.calculadoracalorias.dto.IngredienteDTO;
import com.ejercicio.calculadoracalorias.dto.PlatoDTO;
import com.ejercicio.calculadoracalorias.service.IPlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlatoController {


    @Autowired
    private IPlatoService platoService;


    @GetMapping("/AllIngredients/{query}")
    public List<IngredienteDTO> allIngredients(@PathVariable String query){
        return platoService.getAllIngredients(query);
    }
    @GetMapping("/statsPlato/{name}")
    public ResponseEntity<String> showStatsPlato(@PathVariable String name){
        return new ResponseEntity<>(platoService.statsPlato(name), HttpStatus.OK);
    }

}
