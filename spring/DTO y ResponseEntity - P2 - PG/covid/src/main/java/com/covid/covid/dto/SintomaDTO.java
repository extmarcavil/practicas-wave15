package com.covid.covid.dto;

import lombok.*;
import java.io.Serializable;

@Getter
@Setter
public class SintomaDTO implements Serializable {
    String codigo;
    String nombre;
    String nivelDeGravedad;

    public SintomaDTO(String codigo, String nombre, String nivelDeGravedad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nivelDeGravedad = nivelDeGravedad;
    }
}
