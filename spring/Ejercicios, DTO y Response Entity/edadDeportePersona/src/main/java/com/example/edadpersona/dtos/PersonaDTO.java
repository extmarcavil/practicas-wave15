package com.example.edadpersona.dtos;

import java.io.Serializable;
import java.util.List;

public class PersonaDTO implements Serializable {
    private String nombre;
    private String apellido;
    private List<String> deportes;

    public PersonaDTO() {
    }

    public PersonaDTO(String nombre, String apellido, List<String> deportes) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.deportes = deportes;
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

    public List<String> getDeportes() {
        return deportes;
    }

    public void setDeportes(List<String> deportes) {
        this.deportes = deportes;
    }
}
