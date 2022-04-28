package com.example.calculadoracalorias.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class DishesDTO {
    private String name;
    private List<IngredientsDTO> ingredients;
    private double weight;
}
