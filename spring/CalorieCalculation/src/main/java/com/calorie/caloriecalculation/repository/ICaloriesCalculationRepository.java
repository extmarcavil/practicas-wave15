package com.calorie.caloriecalculation.repository;

import com.calorie.caloriecalculation.model.Food;

public interface ICaloriesCalculationRepository {

    Food findFood(String name, float weight);
}
