package ar.com.alehenestroza.apicalculadoracalorias.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Dish {
    private String name;
    private List<Ingredient> ingredients;
    private Integer calories;

    public Dish(String name, List<Ingredient> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
        this.calories = ingredients.stream().mapToInt(Ingredient::getCalories).sum();
    }
}
