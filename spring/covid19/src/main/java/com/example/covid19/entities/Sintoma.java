package com.example.covid19.entities;

public class Sintoma {

    private Integer id;
    private String nombre;
    private Integer nivelDeGravedad;

    public Sintoma() {
    }

    public Sintoma(Integer id, String nombre, Integer nivelDeGravedad) {
        this.id = id;
        this.nombre = nombre;
        this.nivelDeGravedad = nivelDeGravedad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNivelDeGravedad() {
        return nivelDeGravedad;
    }

    public void setNivelDeGravedad(Integer nivelDeGravedad) {
        this.nivelDeGravedad = nivelDeGravedad;
    }
}
