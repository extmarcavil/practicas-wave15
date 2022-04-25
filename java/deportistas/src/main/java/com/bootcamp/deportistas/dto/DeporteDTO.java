package com.bootcamp.deportistas.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeporteDTO {
    private String nombre;
    private Integer nivel;

    public DeporteDTO(String nombre, Integer nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
    }
}

