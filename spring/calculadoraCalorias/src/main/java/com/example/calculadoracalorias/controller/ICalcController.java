package com.example.calculadoracalorias.controller;

import com.example.calculadoracalorias.DTO.DishDTO;
import com.example.calculadoracalorias.DTO.DishResponseDTO;
import com.example.calculadoracalorias.model.Ingredient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ICalcController {

    ResponseEntity<DishResponseDTO> calculateADish(@RequestBody DishDTO dish);

    ResponseEntity<List<DishResponseDTO>> calculateDishes(@RequestBody List<DishDTO> dishes);

    ResponseEntity<List<Ingredient>> getIngredients();


}
