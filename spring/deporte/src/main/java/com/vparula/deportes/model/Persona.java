package com.vparula.deportes.model;

import java.util.List;
import java.util.stream.Collectors;

public class Persona {
    String nombre;
    String apellido;
    int edad;
    List<Deporte> deportesPractica;


    public Persona(String nombre, String apellido, int edad, List<Deporte> deportesPractica) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.deportesPractica = deportesPractica;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }



    public boolean haceDeportes(){

        return this.deportesPractica!=null;
    }

    public List<String> devuelvoDeportes(){
        List<String> deportes = this.deportesPractica.stream().map(d -> d.getNombre()).collect(Collectors.toList());
        return deportes;
    }
}
