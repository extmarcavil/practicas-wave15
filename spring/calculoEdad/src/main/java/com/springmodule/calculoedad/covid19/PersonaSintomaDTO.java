package com.springmodule.calculoedad.covid19;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class PersonaSintomaDTO implements Serializable {
    private String id;
    private String nombre;
    private String apellido;
    private int edad;
    private long codigo;
    private String nombreSintoma;
    private int nivelDeGravedad;
}
