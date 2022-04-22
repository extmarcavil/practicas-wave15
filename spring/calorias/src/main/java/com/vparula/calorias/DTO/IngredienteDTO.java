package com.vparula.calorias.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class IngredienteDTO {
    String nombre;

    int calorias;

    public IngredienteDTO() {
    }

    public IngredienteDTO(String nombre, int calorias) {
        this.nombre = nombre;
        this.calorias = calorias;
    }
}
