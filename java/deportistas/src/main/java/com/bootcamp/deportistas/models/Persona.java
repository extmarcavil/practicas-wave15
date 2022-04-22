package com.bootcamp.deportistas.models;

import java.util.ArrayList;
import java.util.List;

public class Persona {

    private String nombre;
    private String apellido;
    private int edad;
    private List<Deporte> listDeportes = new ArrayList<>();
    
    public Persona() {
    }

    public Persona(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public Persona(String nombre, String apellido, List<Deporte> listDeportes) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.listDeportes = listDeportes;
    }

    public Persona(String nombre, String apellido, int edad, List<Deporte> listDeportes) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.listDeportes = listDeportes;
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

    public List<Deporte> getListDeportes() {
        return listDeportes;
    }

    public void setListDeportes(List<Deporte> list) {
        this.listDeportes = list;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
