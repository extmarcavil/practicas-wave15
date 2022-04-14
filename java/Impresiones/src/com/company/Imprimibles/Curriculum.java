package com.company.Imprimibles;

import com.company.Imprimir;
import com.company.Persona;

import java.util.ArrayList;
import java.util.List;

public class Curriculum implements Imprimir {

    Persona persona;

    public Curriculum(Persona persona) {
        this.persona = persona;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "persona=" + persona +
                '}';
    }

    @Override
    public void imprimir() {
        System.out.println("Este es el Curriculum");
        System.out.println(persona);
    }
}
