package com.practicas.deportistas.dto;

public class Deporte {
    private String nombre;
    private int nivel;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public Deporte(String nombre, int nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
    }
}
