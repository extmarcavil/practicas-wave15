package com.meli.convert.services.impl;

import com.meli.convert.dto.MeatInfoRsDTO;
import com.meli.convert.model.Food;
import com.meli.convert.model.Ingredient;
import com.meli.convert.repository.FoodRepository;
import com.meli.convert.repository.IngredientRepository;
import com.meli.convert.services.CaloriesCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CaloriesCalculatorServiceImpl implements CaloriesCalculatorService {

    @Autowired
    FoodRepository foodRepository;
    @Autowired
    IngredientRepository ingredientRepository;

    @Override
    public MeatInfoRsDTO getMeatInfo(String name, Double grams) {
        Food food = this.foodRepository.getFodd(name);

        MeatInfoRsDTO meatInfoRsDTO = new MeatInfoRsDTO();
        ArrayList<Ingredient> ingredients = new ArrayList<>(food.getIngredients()
                .keySet());
        meatInfoRsDTO.setIngredients(ingredients);

        meatInfoRsDTO.setAmountCalories(food
                .getIngredients()
                .keySet()
                .stream()
                .mapToDouble(Ingredient::getCalories).sum());
        return meatInfoRsDTO;
    }
}
