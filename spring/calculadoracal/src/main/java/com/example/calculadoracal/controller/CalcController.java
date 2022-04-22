package com.example.calculadoracal.controller;

import com.example.calculadoracal.dto.FoodInfoDTO;
import com.example.calculadoracal.dto.FoodRequestDTO;
import com.example.calculadoracal.service.IFoodService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/food")
public class CalcController {

    private final IFoodService foodService;
    
    public CalcController(IFoodService foodService){
        this.foodService = foodService;
    }

    @GetMapping("/info/{name}")
    public ResponseEntity<FoodInfoDTO> getTotalCaloriesByFood(@PathVariable String name,
                                                              @RequestParam Integer weight){
        try {
            return ResponseEntity.ok(foodService.findFoodInfo(name, weight));
        } catch (NoSuchElementException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/info")
    public ResponseEntity<List<FoodInfoDTO>> getTotalCaloriesByFoodList(@RequestBody List<FoodRequestDTO> foodRequestDTO){
        try {
            return ResponseEntity.ok(foodService.findFoodListInfo(foodRequestDTO));
        } catch (NoSuchElementException e){
            return ResponseEntity.notFound().build();
        }
    }
}
