package com.Spring.Covid19.model;

public class Persona {
    private Integer id;
    private String apellido;
    private String nombre;
    private Integer edad;

    public Persona() {
    }

    public Persona(Integer id, String apellido, String nombre, Integer edad) {
        this.id = id;
        this.apellido = apellido;
        this.nombre = nombre;
        this.edad = edad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }
}
