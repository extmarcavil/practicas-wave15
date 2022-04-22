package com.bootcamp.calculadoracalorias.controller;

import com.bootcamp.calculadoracalorias.dtos.MealCaloriesDTO;
import com.bootcamp.calculadoracalorias.dtos.MealDTO;
import com.bootcamp.calculadoracalorias.service.ICalculadoraService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class CalculadoraController {
    private ICalculadoraService calculadoraService;

    public CalculadoraController(ICalculadoraService calculadoraService){
        this.calculadoraService = calculadoraService;
    }

    @GetMapping("/{name}/{peso}")
    public ResponseEntity<MealCaloriesDTO> getMeal(@PathVariable String name, @PathVariable Integer peso){
        return new ResponseEntity<>(calculadoraService.getMeal(name, peso), HttpStatus.OK);
    }

    @GetMapping("/menu")
    public ResponseEntity<List<MealDTO>> getMeals(){
        return new ResponseEntity<>(calculadoraService.getMeals(), HttpStatus.OK);
    }

}
