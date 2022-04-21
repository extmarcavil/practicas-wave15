package com.example.spring.entity;

public class DeporteEntity {

    private String nombre;
    private Integer nivel;


    public DeporteEntity(String nombre, Integer nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getNivel() {
        return nivel;
    }
}
