package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Persona {
    String nombre;
    String Apellido;
    int edad;
    Deporte deporte;

    public Persona(String nombre, String apellido, int edad, Deporte deporte) {
        this.nombre = nombre;
        Apellido = apellido;
        this.edad = edad;
        this.deporte = deporte;
    }
}
