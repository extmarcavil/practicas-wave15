package com.example.calculadoracalorias.dto;

import com.example.calculadoracalorias.model.Ingrediente;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PlatoMuestraDTO {
    private String nombre;
    private List<Ingrediente> ingredientes;
    private Integer caloriasPlato;
    private Ingrediente caloriasMaximas;

    public PlatoMuestraDTO(String nombre, List<Ingrediente> ingredientes) {
        this.nombre = nombre;
        this.ingredientes = ingredientes;
    }
}
