package com.meli.convert.model;

import java.util.HashMap;

public class Food {
    private String name;
    private HashMap<Ingredient, Double> ingredients;

    public Food(String name, HashMap<Ingredient, Double> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<Ingredient, Double> getIngredients() {
        return ingredients;
    }

    public void setIngredients(HashMap<Ingredient, Double> ingredients) {
        this.ingredients = ingredients;
    }
}
