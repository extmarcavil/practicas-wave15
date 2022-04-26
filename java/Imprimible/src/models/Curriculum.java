package models;

import interfaces.Imprimible;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Curriculum implements Imprimible {
    String nombre;
    int edad;
    String profesion;
    ArrayList<String> habilidades;

    public Curriculum(String nombre, int edad, String profesion, String[] habilidades) {
        this.nombre = nombre;
        this.edad = edad;
        this.profesion = profesion;
        this.habilidades = new ArrayList<String>();
        Collections.addAll(this.habilidades, habilidades);
    }

    @Override
    public void Imprimir() {
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Edad: " + this.edad);
        System.out.println("Profesión: " + this.profesion);
        System.out.println("Habilidades: " + this.habilidades);
    }
}