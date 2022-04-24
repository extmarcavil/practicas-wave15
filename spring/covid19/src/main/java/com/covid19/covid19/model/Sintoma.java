package com.covid19.covid19.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Sintoma {

    private String codigo;
    private String nombre;
    private int nivel_de_gravedad;

    public Sintoma(String codigo, String nombre, int nivel_de_gravedad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nivel_de_gravedad = nivel_de_gravedad;
    }

    @Override
    public String toString() {
        return "Sintoma{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", nivel_de_gravedad=" + nivel_de_gravedad +
                '}';
    }


    public String getNombre() {
        return nombre;
    }
}
