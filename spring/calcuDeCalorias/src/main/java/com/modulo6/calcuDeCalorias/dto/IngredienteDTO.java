package com.modulo6.calcuDeCalorias.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IngredienteDTO {

    private String  name;
    private Integer calories;

    public IngredienteDTO(String name, Integer calories) {
        this.name = name;
        this.calories = calories;
    }

    public IngredienteDTO() {
    }

    @Override
    public String toString() {
        return "IngredienteDTO{" +
                "name='" + name + '\'' +
                ", calories=" + calories +
                '}';
    }
}
