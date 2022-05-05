package com.bootcamp.coviddto.dtos;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class SintomaDTO implements Serializable {
    private String nombre;
    private int nivelGravedad;

    public SintomaDTO(String nombre, int nivelGravedad) {
        this.nombre = nombre;
        this.nivelGravedad = nivelGravedad;
    }
}
