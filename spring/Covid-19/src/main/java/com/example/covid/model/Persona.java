package com.example.covid.model;

import java.util.ArrayList;
import java.util.List;

public class Persona {

    private Integer id;
    private String nombre;
    private String apellido;
    private Integer edad;
    private List<Sintoma> sintomas;

    public Persona(){
        sintomas = new ArrayList<>();
    }

    public Persona(Integer id, String nombre, String apellido, Integer edad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        sintomas = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public List<Sintoma> getSintomas() {
        return sintomas;
    }

    public void setSintomas(List<Sintoma> sintomas) {
        this.sintomas = sintomas;
    }

    public void addAllSintomas(ArrayList<Sintoma> sintomas) {
        this.sintomas.addAll(sintomas);
    }

    public void addSintoma(Sintoma sintoma) {
        this.sintomas.add(sintoma);
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                '}';
    }
}
