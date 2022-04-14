package com.company.animales;

import com.company.Animal;
import com.company.Tipo;

public class Vaca extends Animal{
    public Vaca(String nombre) {
        super(nombre);
    }



    @Override
    public void hacerSonido() {
        System.out.println("muuuuu");
    }

    @Override
    public void tipo() {
        System.out.println("soy herviboro");
    }
}
