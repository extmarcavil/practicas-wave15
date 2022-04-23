package com.calorie.caloriecalculation.service;

import com.calorie.caloriecalculation.dto.FoodDTO;

public interface ICaloriesCalculationService {

    FoodDTO findFood(String name, float weight);
}
