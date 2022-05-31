package com.mercadolibre.gmurias_deportistas_test.model;

public class Deporte {

    private String nombre;
    private String nivel;

    public Deporte(String nombre, String nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
    }

    public Deporte() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
