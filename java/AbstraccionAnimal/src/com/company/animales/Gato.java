package com.company.animales;

import com.company.Animal;
import com.company.Tipo;

public class Gato extends Animal{
    public Gato(String nombre) {
        super(nombre);
    }


    @Override
    public void hacerSonido() {
        System.out.println("Miau");
    }

    @Override
    public void tipo() {
        System.out.println("soy Carnivoro");
    }
}
