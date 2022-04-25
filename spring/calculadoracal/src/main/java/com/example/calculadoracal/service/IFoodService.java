package com.example.calculadoracal.service;

import com.example.calculadoracal.dto.DishCaloriesDTO;
import com.example.calculadoracal.dto.DishDTO;

import java.util.List;

public interface IFoodService {
    DishCaloriesDTO findDishCalories(DishDTO dishDTO);
    List<DishCaloriesDTO> findCaloriesByDish(List<DishDTO> dishDTOS);
}
