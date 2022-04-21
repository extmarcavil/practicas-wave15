package com.Deportistas.Deportistas.model;

public class Deporte {
    private String Nombre;
    private int Nivel;

    public Deporte() {
    }

    public Deporte(String nombre, int nivel) {
        Nombre = nombre;
        Nivel = nivel;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getNivel() {
        return Nivel;
    }

    public void setNivel(int nivel) {
        Nivel = nivel;
    }
}
