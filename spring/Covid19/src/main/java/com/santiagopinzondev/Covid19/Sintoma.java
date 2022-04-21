package com.santiagopinzondev.Covid19;

import java.util.ArrayList;
import java.util.List;

public class Sintoma {
    public String codigo;
    public String nombre;
    public Double nivelDeGravedad;
    List<Sintoma> sintomas = new ArrayList<>();

    public Sintoma(String codigo, String nombre, double nivelDeGravedad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nivelDeGravedad = nivelDeGravedad;
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

    public double getNivelDeGravedad() {
        return nivelDeGravedad;
    }

    public void setNivelDeGravedad(double nivelDeGravedad) {
        this.nivelDeGravedad = nivelDeGravedad;
    }

    @Override
    public String toString() {
        return "Sintoma{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", nivelDeGravedad=" + nivelDeGravedad +
                '}';
    }
}
