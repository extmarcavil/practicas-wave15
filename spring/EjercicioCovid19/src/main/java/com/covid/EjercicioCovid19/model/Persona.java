package com.covid.EjercicioCovid19.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Persona {
    private Integer id;
    private String nombre;
    private String apellido;
    private Integer edad;

    public Persona() {
    }

    public Persona(Integer id, String nombre, String apellido, Integer edad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }
}
