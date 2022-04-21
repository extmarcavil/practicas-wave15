package com.bootcamp.coviddto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Sintoma {
    private int codigo;
    private String nombre;
    private int nivelGravedad;

    public Sintoma(int codigo, String nombre, int nivelGravedad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nivelGravedad = nivelGravedad;
    }
}
