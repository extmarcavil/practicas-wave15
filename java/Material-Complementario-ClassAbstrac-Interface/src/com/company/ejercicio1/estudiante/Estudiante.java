package com.company.ejercicio1.estudiante;

import com.company.ejercicio1.Persona;

import java.util.List;

public abstract class Estudiante extends Persona {

    /**
     * Atributos
     */
    private String gradoCursado;
    private List<String> materias;

    /**
     * Constructor
     *
     * @param nombre
     * @param apeellido
     */
    public Estudiante(String nombre, String apeellido) {
        super(nombre, apeellido);
    }
}
