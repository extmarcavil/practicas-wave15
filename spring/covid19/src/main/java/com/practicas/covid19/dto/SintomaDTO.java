package com.practicas.covid19.dto;

public class SintomaDTO {
    private String nombre;

    public SintomaDTO(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
