package com.bootcamp.calculadoracalorias.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter

public class PlatoDTO {
    String nombre;
    List<IngredientesDTO> ingredientesDto;

    public PlatoDTO(String nombre, List<IngredientesDTO> ingredientesDto) {
        this.nombre = nombre;
        this.ingredientesDto = ingredientesDto;
    }
}
