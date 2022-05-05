package com.example.calculadoracal.service;

import com.example.calculadoracal.dto.TotalCaloriesDTO;

public interface IFoodService {
    TotalCaloriesDTO findFood(String name, Integer weight);
}
