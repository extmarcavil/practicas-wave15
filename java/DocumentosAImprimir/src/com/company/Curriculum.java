package com.company;

import java.util.ArrayList;

public class Curriculum extends Persona implements Imprimir{

    public Curriculum(String nombre, int edad, ArrayList<String> habilidades) {
        super(nombre, edad, habilidades);
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", habilidades=" + habilidades +
                '}';
    }

    @Override
    public void imprimir() {
        System.out.println(toString());
    }
}
