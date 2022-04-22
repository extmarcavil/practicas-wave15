package com.vparula.deportes.model;

public class Deporte {
    String nombre;
    String nivel;

    public Deporte(String nombre, String nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNivel() {
        return nivel;
    }
}
