package com.mercadolibre.gmurias_deportistas_test.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeporteDTO {

    private String nombre;
    private String nivel;

    public DeporteDTO(String nombre, String nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
    }
}
