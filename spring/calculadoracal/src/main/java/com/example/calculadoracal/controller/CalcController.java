package com.example.calculadoracal.controller;

import com.example.calculadoracal.dto.DishCaloriesDTO;
import com.example.calculadoracal.dto.DishDTO;
import com.example.calculadoracal.model.Ingredient;
import com.example.calculadoracal.repository.IIngredientRepo;
import com.example.calculadoracal.service.IFoodService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/* Ejercicio empezado a realizarse en equipo con:
- Ignacio Ferrante
- Oscar Regino
- Tomas Ravelli
- Vaneza Ruiz

  Se asume que ya se tenia una lista de platos que tiene el restaurante
 */

@RestController
public class CalcController {

    private IFoodService foodService;

    public CalcController(IFoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping("/calories/dish")
    public ResponseEntity<DishCaloriesDTO> getTotalCaloriesByFood(@RequestBody DishDTO dishDTO){
        return new ResponseEntity<>(foodService.findDishCalories(dishDTO), HttpStatus.OK);
    }

    @PostMapping("/calories/dishes")
    public  ResponseEntity<List<DishCaloriesDTO>> getAllCaloriesByDish(@RequestBody List<DishDTO> dishDTOS) {
        return new ResponseEntity<>(foodService.findCaloriesByDish(dishDTOS), HttpStatus.OK);
    }
}
