package com.bootcamp.covid.modelo;

public class Sintoma {
    String codigo;
    String nombre;
    Integer nivel_de_gravedad;

    public Sintoma(String codigo, String nombre, Integer nivel_de_gravedad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nivel_de_gravedad = nivel_de_gravedad;
    }
}
