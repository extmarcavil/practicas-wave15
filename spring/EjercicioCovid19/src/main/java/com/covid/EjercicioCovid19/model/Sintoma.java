package com.covid.EjercicioCovid19.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Sintoma {
    private Integer codigo;
    private String nombre;
    private Integer nivel_de_gravedad;

    public Sintoma() {
    }

    public Sintoma(Integer codigo, String nombre, Integer nivel_de_gravedad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nivel_de_gravedad = nivel_de_gravedad;
    }
}
