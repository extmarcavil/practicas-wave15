package com.example.calculadoracalorias.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ingredient {

    private String name;
    private Integer calories;
    private Integer weight;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}
