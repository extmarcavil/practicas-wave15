package com.example.calculadoracal.service;

import com.example.calculadoracal.dto.FoodInfoDTO;
import com.example.calculadoracal.dto.FoodRequestDTO;
import com.example.calculadoracal.model.Food;
import com.example.calculadoracal.model.Ingredient;
import com.example.calculadoracal.repository.IFoodRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class FoodServiceImpl implements IFoodService {

    private final IFoodRepo foodRepo;

    public FoodServiceImpl (IFoodRepo foodRepo){
        this.foodRepo = foodRepo;
    }

    @Override
    public FoodInfoDTO findFoodInfo(String name, Integer weight) {
        float gramosDeCalorias = 100;
        Food food = foodRepo.findByName(name).orElseThrow();
        FoodInfoDTO totalCaloriesDTO = new FoodInfoDTO();
        totalCaloriesDTO.setCalories(food.getIngredients().stream().mapToDouble(i -> (i.getCalories()*weight)/gramosDeCalorias).sum()); //tomando las calorias cada 100 gr
        totalCaloriesDTO.setMostCaloriesIngredient(food.getIngredients().stream().max(Comparator.comparing(Ingredient::getCalories)).orElseThrow());
        totalCaloriesDTO.setIngredients(food.getIngredients());
        return totalCaloriesDTO;
    }

    @Override
    public List<FoodInfoDTO> findFoodListInfo(List<FoodRequestDTO> foodRequestDTO) {
        float gramosDeCalorias = 100;
        List<FoodInfoDTO> resultado = new ArrayList<>();
        for (FoodRequestDTO f: foodRequestDTO) {
            Food food = foodRepo.findByName(f.getName()).orElseThrow();
            FoodInfoDTO totalCaloriesDTO = new FoodInfoDTO();
            totalCaloriesDTO.setCalories(food.getIngredients().stream().mapToDouble(i -> (i.getCalories()*f.getWeight())/gramosDeCalorias).sum()); //tomando las calorias cada 100 gr
            totalCaloriesDTO.setMostCaloriesIngredient(food.getIngredients().stream().max(Comparator.comparing(Ingredient::getCalories)).orElseThrow());
            totalCaloriesDTO.setIngredients(food.getIngredients());
            resultado.add(totalCaloriesDTO);
        }
        return resultado;
    }
}
