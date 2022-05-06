package com.company.ejercicio1.personal;

import java.time.LocalDate;

public class Profesor extends Personal {

    /**
     * Atributos
     */
    private String materia;
    private LocalDate añosDeExperiencia;

    /**
     * Constructor
     *
     * @param nombre
     * @param apeellido
     * @param cargo
     */
    public Profesor(String nombre, String apeellido, String cargo) {
        super(nombre, apeellido, cargo);
    }
}
