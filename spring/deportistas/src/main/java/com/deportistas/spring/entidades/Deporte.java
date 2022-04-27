package com.deportistas.spring.entidades;

import java.util.ArrayList;
import java.util.List;

public class Deporte {

    List<Deporte> lista = new ArrayList<>();

    private String nombre;
    private int nivel;

    public Deporte(String nombre, int nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.lista.add(new Deporte(nombre,nivel));
    }

    public Deporte() {

    }

    public List<Deporte> getLista() {
        return lista;
    }

    public void setLista(List<Deporte> lista) {
        this.lista = lista;
    }

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
}
