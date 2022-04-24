package com.example.EjercicioCovid.dto;

public class SintomaDTO {
    private String codigo;
    private String nombre;
    private String nivel_de_gravedad;

    public SintomaDTO(String codigo, String nombre, String nivel_de_gravedad) {
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

    public String getNivel_de_gravedad() {
        return nivel_de_gravedad;
    }

    public void setNivel_de_gravedad(String nivel_de_gravedad) {
        this.nivel_de_gravedad = nivel_de_gravedad;
    }
}
