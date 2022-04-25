package com.springmodule.calculoedad.covid19;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Sintoma {
    private long codigo;
    private String nombre;
    private int nivelDeGravedad;

    public Sintoma(long codigo, String nombre, int nivelDeGravedad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nivelDeGravedad = nivelDeGravedad;
    }
}
