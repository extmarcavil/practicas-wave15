package com.example.calculadoracalorias.controller;

import com.example.calculadoracalorias.dto.DishDTO;
import com.example.calculadoracalorias.dto.response.CaloriesResponseDTO;
import com.example.calculadoracalorias.service.IFoodService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoodController {

    private final IFoodService service;

    public FoodController(IFoodService service) {
        this.service = service;
    }

    @GetMapping("/get_calories")
    public ResponseEntity<CaloriesResponseDTO> getCalories(@RequestBody DishDTO dish){
        return new ResponseEntity<>(service.getCalories(dish), HttpStatus.OK);
    }
}
