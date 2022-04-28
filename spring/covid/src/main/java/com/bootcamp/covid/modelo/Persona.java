package com.bootcamp.covid.modelo;

public class Persona {
    Integer id;
    String nombre;
    String apellido;
    Integer edad;

    public Persona(Integer id, String nombre, String apellido, Integer edad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }
}
