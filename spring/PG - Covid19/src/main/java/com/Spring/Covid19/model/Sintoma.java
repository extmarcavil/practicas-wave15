package com.Spring.Covid19.model;

public class Sintoma {

    private Integer codigo;
    private String nombre;
    private String nivelDeGravedad;

    public Sintoma() {
    }

    public Sintoma(Integer codigo, String nombre, String nivelDeGravedad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nivelDeGravedad = nivelDeGravedad;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNivelDeGravedad() {
        return nivelDeGravedad;
    }

    public void setNivelDeGravedad(String nivelDeGravedad) {
        this.nivelDeGravedad = nivelDeGravedad;
    }

    @Override
    public String toString() {
        return codigo + " " + nombre + " " + nivelDeGravedad;
    }
}
