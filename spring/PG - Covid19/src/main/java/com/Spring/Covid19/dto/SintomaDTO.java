package com.Spring.Covid19.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SintomaDTO {
    private Integer codigo;
    private String nombre;
    private String nivelDeGravedad;

    public SintomaDTO(Integer codigo, String nombre, String nivelDeGravedad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nivelDeGravedad = nivelDeGravedad;
    }
}
