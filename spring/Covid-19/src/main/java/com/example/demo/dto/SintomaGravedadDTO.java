package com.example.demo.dto;

public class SintomaGravedadDTO {

    private String nivelDeGravedad;

    public SintomaGravedadDTO(String nivelDeGravedad) {
        this.nivelDeGravedad = nivelDeGravedad;
    }

    public String getNivelDeGravedad() {
        return nivelDeGravedad;
    }

    public void setNivelDeGravedad(String nivelDeGravedad) {
        this.nivelDeGravedad = nivelDeGravedad;
    }
}
