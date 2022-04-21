package com.covid.spring.entidades;

import java.io.Serializable;


public class SintomaticoDTO implements Serializable {

    private String nombreCompleto;
    private int edad;
    private Sintoma sintoma;

    public SintomaticoDTO(String nombreCompleto, int edad, Sintoma sintoma) {
        this.nombreCompleto = nombreCompleto;
        this.edad = edad;
        this.sintoma = sintoma;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Sintoma getSintoma() {
        return sintoma;
    }

    public void setSintoma(Sintoma sintoma) {
        this.sintoma = sintoma;
    }
}
