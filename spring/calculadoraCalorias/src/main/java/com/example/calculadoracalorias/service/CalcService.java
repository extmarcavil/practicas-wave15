package com.example.calculadoracalorias.service;

import com.example.calculadoracalorias.DTO.DishDTO;
import com.example.calculadoracalorias.DTO.DishResponseDTO;
import com.example.calculadoracalorias.model.Ingredient;
import com.example.calculadoracalorias.repository.CalcRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalcService implements ICalcService{

    private final CalcRepository calcRepository;

    public CalcService(CalcRepository calcRepository) {
        this.calcRepository = calcRepository;
    }

    @Override
    public DishResponseDTO calcDishCalories(DishDTO dishDTO) { return calcRepository.calculateCalories(dishDTO); }

    @Override
    public List<DishResponseDTO> calcAllDishesCalories(List<DishDTO> dishDTO) { return calcRepository.calculateAllCalories(dishDTO); }

    @Override
    public List<Ingredient> getIngredientsList() { return calcRepository.getAllIngredients(); }


}
