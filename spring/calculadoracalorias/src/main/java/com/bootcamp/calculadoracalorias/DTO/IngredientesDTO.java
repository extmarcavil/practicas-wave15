package com.bootcamp.calculadoracalorias.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class IngredientesDTO {
    String nombre;
    int calorias;
    int cantidadIngredientes;

    public IngredientesDTO(String nombre, int calorias, int cantidadIngredientes) {
        this.nombre = nombre;
        this.calorias = calorias;
        this.cantidadIngredientes = cantidadIngredientes;
    }
}
