package com.company;

import java.util.ArrayList;
import java.util.List;

public class Curriculum {

    private String nombre;
    List<String> skills;

    public Curriculum(String nombre) {
        this.nombre = nombre;
        this.skills= new ArrayList<>();
        skills.add("Proactivo");
        skills.add("Competitivo");
    }


    @Override
    public String toString() {
        return "Curriculum{" +
                "nombre='" + nombre + '\'' +
                ", skills=" + skills +
                '}';
    }
}
