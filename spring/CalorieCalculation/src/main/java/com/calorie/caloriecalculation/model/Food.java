package com.calorie.caloriecalculation.model;

import java.util.List;

public class Food {

    private String name;
    private float weight;
    private List<Ingredient> ingredients;

    public Food(String name, float weight, List<Ingredient> ingredients) {
        this.name = name;
        this.weight = weight;
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}
