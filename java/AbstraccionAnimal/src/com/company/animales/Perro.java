package com.company.animales;

import com.company.Animal;
import com.company.Tipo;

public class Perro extends Animal{
    public Perro(String nombre) {
        super(nombre);
    }

    @Override
    public void hacerSonido() {
        System.out.println("Guau");
    }


    @Override
    public void tipo() {
        System.out.println("Soy carnivoro");
    }
}
