package com.modulo6.calcuDeCalorias.dto;

import com.modulo6.calcuDeCalorias.dto.IngredienteDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PlatoDTO {

    private String name;
    private double calorias;
    List<IngredienteDTO> ingredientes;
    private Double peso;

    public PlatoDTO(String name, double calorias, List<IngredienteDTO> ingredientes, Double peso) {
        this.name = name;
        this.calorias = calorias;
        this.ingredientes = ingredientes;
        this.peso = peso;
    }

    public PlatoDTO(String name, List<IngredienteDTO> ingredientes, Double peso) {
        this.name = name;
        this.ingredientes = ingredientes;
        this.peso = peso;
    }

    public PlatoDTO() {
    }

    @Override
    public String toString() {
        return "PlatoDTO{" +
                "name='" + name + '\'' +
                ", calorias=" + calorias +
                ", ingredientes=" + ingredientes +
                ", peso=" + peso +
                '}';
    }
}
