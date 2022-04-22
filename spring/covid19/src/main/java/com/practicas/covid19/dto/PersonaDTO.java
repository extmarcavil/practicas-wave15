package com.practicas.covid19.dto;

public class PersonaDTO {
    private String nombre;
    private String apellido;
    private String edad;
    private String Sintomas;

    public PersonaDTO() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getSintomas() {
        return Sintomas;
    }

    public void setSintomas(String sintomas) {
        Sintomas = sintomas;
    }

    public PersonaDTO(String nombre, String apellido, String edad, String sintomas) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        Sintomas = sintomas;
    }
}
