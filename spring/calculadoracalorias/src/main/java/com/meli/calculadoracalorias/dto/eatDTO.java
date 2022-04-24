package com.meli.calculadoracalorias.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class eatDTO {
    private String name;
    private List<plateDTO> ingredientes;

    public eatDTO(String name, List<plateDTO> ingredientes) {
        this.name = name;
        this.ingredientes = ingredientes;
    }
}
