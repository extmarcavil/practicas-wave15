package com.covid19.model;

public class Sintoma {

    private String codigo;
    private String nombre;
    private int nivel_de_gravedad;

    public Sintoma() {
    }

    public Sintoma(String codigo, String nombre, int nivel_de_gravedad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nivel_de_gravedad = nivel_de_gravedad;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivel_de_gravedad() {
        return nivel_de_gravedad;
    }

    public void setNivel_de_gravedad(int nivel_de_gravedad) {
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
}
