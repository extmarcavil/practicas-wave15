package com.example.calculadoracalorias.service;

import com.example.calculadoracalorias.dto.DishDTO;
import com.example.calculadoracalorias.dto.IngredientDTO;
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
        response.setTotalCalories(repository.getTotalCalories());
        response.setIngredients(repository.getIngredients());
        response.setIngredientMaxCalories(repository.getMaxCalories());
        return null;
    }
}
