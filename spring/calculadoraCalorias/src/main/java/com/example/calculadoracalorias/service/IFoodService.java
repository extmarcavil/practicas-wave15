package com.example.calculadoracalorias.service;

import com.example.calculadoracalorias.dto.DishDTO;
import com.example.calculadoracalorias.dto.response.CaloriesResponseDTO;


public interface IFoodService {

    CaloriesResponseDTO getCalories(DishDTO dish);
}
