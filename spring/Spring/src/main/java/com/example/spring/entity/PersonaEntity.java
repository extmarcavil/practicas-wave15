package com.example.spring.entity;

public class PersonaEntity {

    private String nombre;
    private String apellido;
    private Integer edad;


    public PersonaEntity(String nombre, String apellido, Integer edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Integer getEdad() {
        return edad;
    }
}
