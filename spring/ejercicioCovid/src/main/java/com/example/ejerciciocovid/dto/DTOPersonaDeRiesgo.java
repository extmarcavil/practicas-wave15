package com.example.ejerciciocovid.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class DTOPersonaDeRiesgo implements Serializable {

    private String nombre;
    private String apellido;

    public DTOPersonaDeRiesgo(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }
}
