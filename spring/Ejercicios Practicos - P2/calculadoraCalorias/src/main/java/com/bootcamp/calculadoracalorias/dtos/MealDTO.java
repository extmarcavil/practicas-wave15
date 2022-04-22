package com.bootcamp.calculadoracalorias.dtos;

import com.bootcamp.calculadoracalorias.model.Ingredient;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MealDTO {
    private String name;
    List<Ingredient> ingredienteList;
}
