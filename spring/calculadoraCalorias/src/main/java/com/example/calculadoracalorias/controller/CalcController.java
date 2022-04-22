package com.example.calculadoracalorias.controller;

import com.example.calculadoracalorias.DTO.DishDTO;
import com.example.calculadoracalorias.DTO.DishResponseDTO;
import com.example.calculadoracalorias.model.Ingredient;
import com.example.calculadoracalorias.service.CalcService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CalcController implements ICalcController{

    private final CalcService service;

    public CalcController(CalcService calcService) {
        this.service = calcService;
    }

    @Override
    @PostMapping("/calc")
    public ResponseEntity <DishResponseDTO> calculateADish(@RequestBody DishDTO dish){
        return new ResponseEntity<>(service.calcDishCalories(dish), HttpStatus.OK);
    }

    @Override
    @PostMapping("/calcAll")
    public ResponseEntity <List<DishResponseDTO>> calculateDishes(@RequestBody List<DishDTO> dishes){
        return new ResponseEntity<>( service.calcAllDishesCalories(dishes), HttpStatus.OK);
    }

    @Override
    @GetMapping("/ingredients")
    public ResponseEntity<List<Ingredient>> getIngredients() {
        return new ResponseEntity<>(service.getIngredientsList(), HttpStatus.OK);
    }
}
