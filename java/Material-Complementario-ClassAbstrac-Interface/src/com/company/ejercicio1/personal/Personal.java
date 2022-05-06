package com.company.ejercicio1.personal;

import com.company.ejercicio1.Persona;

public abstract class Personal  extends Persona {

    /**
     * Atributos
     */
    private String cargo;

    /**
     * Constructor
     */
    public Personal(String nombre, String apeellido, String cargo) {
        super(nombre, apeellido);
        this.cargo = cargo;
    }
}
