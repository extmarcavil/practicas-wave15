package com.company;

import java.util.ArrayList;

public class Persona {
    String nombre;
    int edad;
    ArrayList<String> habilidades;

    public Persona(String nombre, int edad, ArrayList<String> habilidades) {
        this.nombre = nombre;
        this.edad = edad;
        this.habilidades = habilidades;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public ArrayList<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(ArrayList<String> habilidades) {
        this.habilidades = habilidades;
    }
}
