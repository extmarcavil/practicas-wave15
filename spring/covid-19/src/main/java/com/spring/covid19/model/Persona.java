package com.spring.covid19.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Persona {

    private Integer id;
    private String nombre;
    private String apellido;
    private Integer edad;
    private List<Sintoma> sintomas;

    public Persona(Integer id, String nombre, String apellido, Integer edad, List<Sintoma> sintomas) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.sintomas = sintomas;
    }

    public boolean tieneSintomas() {
        return !sintomas.isEmpty();
    }

    public boolean esMayor() {
        return edad >= 60;
    }
}
