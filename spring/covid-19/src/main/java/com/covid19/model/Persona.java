package com.covid19.model;

import java.util.List;

public class Persona {

    private String id;
    private String nombre;
    private String apellido;
    private int edad;
    private List<Sintoma> listSintomas;


    public Persona(String id, String nombre, String apellido, int edad, List<Sintoma> listSintomas) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.listSintomas = listSintomas;
    }

    public Persona() {

    }


    public List<Sintoma> getListSintomas() {
        return listSintomas;
    }

    public void setListSintomas(List<Sintoma> listSintomas) {
        this.listSintomas = listSintomas;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                '}';
    }
}
