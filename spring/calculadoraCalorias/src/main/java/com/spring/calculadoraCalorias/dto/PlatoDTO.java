package com.spring.calculadoraCalorias.dto;

import com.spring.calculadoraCalorias.model.Ingrediente;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PlatoDTO {

    private double caloriasTotales;
    private List<Ingrediente> ingredientes;
    private Ingrediente ingredienteMayorCalorias;

    public PlatoDTO(double caloriasTotales, List<Ingrediente> ingredientes, Ingrediente ingredienteMayorCalorias) {
        this.caloriasTotales = caloriasTotales;
        this.ingredientes = ingredientes;
        this.ingredienteMayorCalorias = ingredienteMayorCalorias;
    }
}
