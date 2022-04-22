package com.meli.convert.dto;

import com.meli.convert.model.Ingredient;

import java.util.List;

public class MeatInfoRsDTO {
    private Double amountCalories;
    private List<Ingredient> ingredients;
    private Ingredient highestCalorieIngredient;

    public Double getAmountCalories() {
        return amountCalories;
    }

    public void setAmountCalories(Double amountCalories) {
        this.amountCalories = amountCalories;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Ingredient getHighestCalorieIngredient() {
        return highestCalorieIngredient;
    }

    public void setHighestCalorieIngredient(Ingredient highestCalorieIngredient) {
        this.highestCalorieIngredient = highestCalorieIngredient;
    }
}
