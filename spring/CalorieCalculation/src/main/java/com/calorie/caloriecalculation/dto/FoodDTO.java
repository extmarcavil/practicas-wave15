package com.calorie.caloriecalculation.dto;

import com.calorie.caloriecalculation.model.Ingredient;

import java.util.List;

public class FoodDTO {

    private double totalCalories;
    private List<Ingredient> ingredients;
    private Ingredient ingredient;

    public FoodDTO(double totalCalories, List<Ingredient> ingredients, Ingredient ingredient) {
        this.totalCalories = totalCalories;
        this.ingredients = ingredients;
        this.ingredient = ingredient;
    }

    public double getTotalCalories() {
        return totalCalories;
    }

    public void setTotalCalories(double totalCalories) {
        this.totalCalories = totalCalories;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }
}
