package com.ejercicio.covid.dtos;

public class SintomaDTO {

    private int codigo;
    private String nombre;
    private String nivelGravedad;

    public SintomaDTO(int codigo, String nombre, String nivelGravedad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nivelGravedad = nivelGravedad;
    }
    public SintomaDTO(){

    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNivelGravedad() {
        return nivelGravedad;
    }

    public void setNivelGravedad(String nivelGravedad) {
        this.nivelGravedad = nivelGravedad;
    }
}
