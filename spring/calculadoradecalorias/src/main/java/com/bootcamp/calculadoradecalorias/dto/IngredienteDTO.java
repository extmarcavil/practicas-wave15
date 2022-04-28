package com.bootcamp.calculadoradecalorias.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IngredienteDTO {
    private String name;
    private Integer calories;

    public IngredienteDTO() {
    }
}
