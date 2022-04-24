package com.example.EjercicioCovid.dto;

import java.util.List;

public class PacienteDTO {

    String nombre;
    String apellido;
    List<SintomaDTO> listaSintomas;

    public PacienteDTO(String nombre, String apellido, List<SintomaDTO> listaSintomas) {
        this.nombre = nombre;
        this.apellido = apellido;
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
}
