package com.example.ejercicioDeportistas.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Persona {

    private String nombre;
    private String apellido;
    private int edad;

    public Persona(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }
}
