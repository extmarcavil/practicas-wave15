package com.spring.covid19.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Sintoma {

    private Integer codigo;
    private String nombre;
    private Integer nivelDeGravedad;

    public Sintoma(Integer codigo, String nombre, Integer nivelDeGravedad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nivelDeGravedad = nivelDeGravedad;
    }
}
