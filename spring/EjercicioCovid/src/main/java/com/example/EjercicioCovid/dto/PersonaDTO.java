package com.example.EjercicioCovid.dto;

import org.springframework.web.bind.annotation.PathVariable;

import java.io.Serializable;
import java.util.List;

public class PersonaDTO {

    String nombre;
    String apellido;
    int edad;
    List<SintomaDTO> listaSintomas;

    public PersonaDTO(String nombre, String apellido, int edad, List<SintomaDTO> listaSintomas) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.listaSintomas = listaSintomas;
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

    public List<SintomaDTO> getListaSintomas() {
        return listaSintomas;
    }

    public void setListaSintomas(List<SintomaDTO> listaSintomas) {
        this.listaSintomas = listaSintomas;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
