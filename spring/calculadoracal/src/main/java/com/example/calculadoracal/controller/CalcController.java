package com.example.calculadoracal.controller;

import com.example.calculadoracal.dto.TotalCaloriesDTO;
import com.example.calculadoracal.model.Ingredient;
import com.example.calculadoracal.repository.IIngredientRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CalcController {

    private IIngredientRepo ingredientRepo;
    public CalcController(IIngredientRepo ingredientRepo){
        this.ingredientRepo = ingredientRepo;
    }
    @GetMapping("/calories/{name}")
    public List<Ingredient> getTotalCaloriesByFood(@PathVariable String name,
                                                   @RequestParam Integer weight){
        return ingredientRepo.findAll();
    }
}
