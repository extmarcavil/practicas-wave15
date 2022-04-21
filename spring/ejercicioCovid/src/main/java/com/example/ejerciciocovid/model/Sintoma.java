package com.example.ejerciciocovid.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Sintoma {

    private int codigo;
    private String nombre;
    private String nivel_de_gravedad;

    public Sintoma(int codigo, String nombre, String nivel_de_gravedad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nivel_de_gravedad = nivel_de_gravedad;
    }
}
