package com.spring.deportistas.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Deporte {

    private String nombre;
    private Integer nivel;

    public Deporte(String nombre, Integer nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
    }
}
