package com.vparula.covid.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
public class SintomasDTO implements Serializable {
    private int codigo;
    private String nombre;
    private String nivel_de_gravedad;

    public SintomasDTO (int codigo, String nombre, String nivel_de_gravedad ) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nivel_de_gravedad = nivel_de_gravedad;
    }

}
