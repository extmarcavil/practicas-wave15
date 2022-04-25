package com.bootcamp.calculadoradecalorias.dto;

import com.bootcamp.calculadoradecalorias.model.Ingrediente;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PlatoCaloriasDTO {
    private Integer calories;
    private List<Ingrediente> ingredienteList;
    private String ingredienteMayorCal;

    public PlatoCaloriasDTO(){

    }

}
