package com.example.ejerciciocovid.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class RiskPersonDTO implements Serializable {

    private String nombre;
    private String apellido;

    public RiskPersonDTO(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }
}
