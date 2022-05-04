package com.spring.ejerciciocalculadoracalorias.dto;

import java.util.List;

public class PlatoDTO {
    private String name;
    private List<IngredienteDTO> ingredientes;

    public PlatoDTO(String name, List<IngredienteDTO> ingredientes) {
        this.name = name;
        this.ingredientes = ingredientes;
    }
}
