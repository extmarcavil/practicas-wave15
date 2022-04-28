package com.bootcamp.calculadoracalorias.dto;

import com.bootcamp.calculadoracalorias.model.Ingrediente;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PlatoDTO {

    private String nombre;
    private List<Ingrediente> ingredientes;
    private Integer caloriasPlato;
    private Integer caloriasMaximas;

    public PlatoDTO(String nombre, List<Ingrediente> ingredientes) {
        this.nombre = nombre;
        this.ingredientes = ingredientes;
        //this.caloriasPlato = this.ingredientes.stream().map
    }
}
