package com.bootcamp.calculadoracalorias.service;

import com.bootcamp.calculadoracalorias.dtos.MealCaloriesDTO;
import com.bootcamp.calculadoracalorias.dtos.MealDTO;
import com.bootcamp.calculadoracalorias.model.Ingredient;
import com.bootcamp.calculadoracalorias.model.Meal;
import com.bootcamp.calculadoracalorias.repository.ICalculadoraRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;


@Service
public class CalculadoraService implements ICalculadoraService {
    ICalculadoraRepository calculadoraRepository;
    ModelMapper mapper;

    public CalculadoraService(ICalculadoraRepository calculadoraRepository){
        this.calculadoraRepository = calculadoraRepository;
        this.mapper = new ModelMapper();
    }

    @Override
    public MealCaloriesDTO getMeal(String name, Integer peso) {
        Meal meal = calculadoraRepository.getMeal(name);

        return new MealCaloriesDTO(
                calculateCalories(meal.getIngredienteList(), peso),
                meal.getIngredienteList(),
                checkIngredientWithMoreCalories(meal.getIngredienteList())
        );
    }

    @Override
    public List<MealDTO> getMeals() {
        List<Meal> mealList = calculadoraRepository.getMeals();
        Type listType = new TypeToken<List<MealDTO>>(){}.getType();
        return mapper.map(mealList, listType);
    }

    private Integer calculateCalories(List<Ingredient> ingredients, Integer peso){
        return ingredients.stream()
                .mapToInt(Ingredient::getCalories)
                .sum() * peso;
    }

    private String checkIngredientWithMoreCalories(List<Ingredient> ingredients) {
        Integer calorie = 0;
        String name = "";

        for (Ingredient ingredient : ingredients) {
            if(ingredient.getCalories() > calorie){
                calorie = ingredient.getCalories();
                name = ingredient.getName();
            }
        }
        return name;
    }

}
