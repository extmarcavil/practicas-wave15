package com.example.calculadoracalorias.DTO;

import com.example.calculadoracalorias.model.Ingredient;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DishDTO {

    private String name;
    private List<Ingredient> ingredients;

    public DishDTO() {
    }
}
