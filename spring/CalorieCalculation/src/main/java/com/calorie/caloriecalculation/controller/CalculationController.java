package com.calorie.caloriecalculation.controller;

import com.calorie.caloriecalculation.dto.FoodDTO;
import com.calorie.caloriecalculation.service.ICaloriesCalculationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculationController {

    private final ICaloriesCalculationService caloriesCalculationService;

    public CalculationController(ICaloriesCalculationService caloriesCalculationService) {
        this.caloriesCalculationService = caloriesCalculationService;
    }

    @GetMapping("/food/{name}/{weight}")
    public ResponseEntity<FoodDTO> getCalories(@PathVariable String name, @PathVariable Float weight) {
        return ResponseEntity.status(HttpStatus.OK).body(caloriesCalculationService.findFood(name, weight));
    }
}
