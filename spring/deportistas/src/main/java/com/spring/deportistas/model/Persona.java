package com.spring.deportistas.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Persona {

    private String nombre;
    private String apellido;
    private Integer edad;
    private Deporte deporte;

    public Persona(String nombre, String apellido, Integer edad, Deporte deporte) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.deporte = deporte;
    }
}
