package com.example.edadpersona.dtos;

import com.example.edadpersona.model.Deporte;

import java.io.Serializable;

public class DeporteDTO implements Serializable {
    private String nombre;
    private String nivel;

    public DeporteDTO() {
    }

    public DeporteDTO(String nombre, String nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
    }

    public DeporteDTO(Deporte deporte) {
        this.nombre = deporte.getNombre();
        this.nivel = deporte.getNivel();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
}
