package com.bootcamp.calculadoracalorias.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IngredientDTO {
    private String name;
    private Integer calories;

    public IngredientDTO() {
    }
}
