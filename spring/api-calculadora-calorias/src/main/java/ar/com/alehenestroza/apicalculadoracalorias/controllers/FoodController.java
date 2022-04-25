package ar.com.alehenestroza.apicalculadoracalorias.controllers;

import ar.com.alehenestroza.apicalculadoracalorias.models.Ingredient;
import ar.com.alehenestroza.apicalculadoracalorias.services.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/food")
public class FoodController {
    private final FoodService foodService;

    @GetMapping("getCalories/{foodName}")
    public ResponseEntity<Integer> getCalories(@PathVariable String foodName) {
        return ResponseEntity.ok(foodService.getCalories(foodName));
    }

    @GetMapping("getIngredients/{foodName}")
    public ResponseEntity<List<Ingredient>> getIngredients(@PathVariable String foodName) {
        return ResponseEntity.ok(foodService.getIngredients(foodName));
    }

    @GetMapping("mostCaloricIngredients/{foodName}")
    public ResponseEntity<Ingredient> getMostCaloricIngredients(@PathVariable String foodName) {
        return ResponseEntity.ok(foodService.getMostCaloricIngredient(foodName));
    }
}
