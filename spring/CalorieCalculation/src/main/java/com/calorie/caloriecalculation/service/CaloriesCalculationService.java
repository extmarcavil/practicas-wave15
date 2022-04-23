package com.calorie.caloriecalculation.service;

import com.calorie.caloriecalculation.dto.FoodDTO;
import com.calorie.caloriecalculation.model.Food;
import com.calorie.caloriecalculation.model.Ingredient;
import com.calorie.caloriecalculation.repository.ICaloriesCalculationRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;

@Service
public class CaloriesCalculationService implements ICaloriesCalculationService {

    private final ICaloriesCalculationRepository iCaloriesCalculationRepository;

    public CaloriesCalculationService(ICaloriesCalculationRepository iCaloriesCalculationRepository) {
        this.iCaloriesCalculationRepository = iCaloriesCalculationRepository;
    }

    @Override
    public FoodDTO findFood(String name, float weight) {
        Food food = iCaloriesCalculationRepository.findFood(name, weight);
        //calcular calorias total y obtener el alimento mas grande
        double totalCalories = food.getIngredients().stream()
                .mapToDouble(Ingredient::getCalories)
                .sum();

        Ingredient highestCaloriesIngredient = food.getIngredients().stream().
                max(Comparator.comparing(Ingredient::getCalories)).orElse(null);

        return new FoodDTO(totalCalories, food.getIngredients(), highestCaloriesIngredient);
    }
}
