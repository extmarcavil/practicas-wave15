package com.example.EjercicioCovid.model;

public class Sintoma {
    private String codigo;
    private String nombre;
    private int nivel_gravedad;

    public Sintoma(String codigo, String nombre, int nivel_gravedad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nivel_gravedad = nivel_gravedad;
    }
}
