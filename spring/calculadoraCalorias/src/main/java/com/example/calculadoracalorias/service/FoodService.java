package com.example.calculadoracalorias.service;

import com.example.calculadoracalorias.dto.DishDTO;
import com.example.calculadoracalorias.dto.response.CaloriesResponseDTO;
import com.example.calculadoracalorias.repository.IFoodRepository;
import org.springframework.stereotype.Service;

@Service
public class FoodService implements IFoodService {

    private final IFoodRepository repository;

    public FoodService(IFoodRepository repository) {
        this.repository = repository;
    }

    @Override
    public CaloriesResponseDTO getCalories(DishDTO dish) {
        CaloriesResponseDTO response = new CaloriesResponseDTO();
        response.setTotalCalories(repository.getTotalCalories(dish));
        response.setIngredients(repository.getIngredients(dish));
        response.setIngredientMaxCalories(repository.getMaxCalories(dish));
        return null;
    }
}
