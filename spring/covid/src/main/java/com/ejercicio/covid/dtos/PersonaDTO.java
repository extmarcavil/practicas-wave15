package com.ejercicio.covid.dtos;

import com.ejercicio.covid.models.Sintoma;

import java.util.List;

public class PersonaDTO {

    private String nombre;
    private String apellido;
    private List<SintomaDTO> sintomas;
    private int edad;

    public PersonaDTO(String nombre, String apellido, int edad, List<SintomaDTO> sintomas) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.sintomas = sintomas;
        this.edad = edad;
    }

   public PersonaDTO(){

   }



    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
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

    public List<SintomaDTO> getSintomas() {
        return sintomas;
    }

    public void setSintomas(List<SintomaDTO> sintomas) {
        this.sintomas = sintomas;
    }
}
