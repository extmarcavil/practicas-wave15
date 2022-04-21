package com.meli.convert.model;

public class Sintoma {

    private Long codigo;
    private String nombre;
    private Integer nivelGravedad;

    public Sintoma(Long codigo, String nombre, Integer nivelGravedad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nivelGravedad = nivelGravedad;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNivelGravedad() {
        return nivelGravedad;
    }

    public void setNivelGravedad(Integer nivelGravedad) {
        this.nivelGravedad = nivelGravedad;
    }
}
