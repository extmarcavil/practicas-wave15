package com.vparula.deportes.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeporteDTO {
    String nombre;
    String nivel;

    public DeporteDTO(String nombre, String nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
    }
}
