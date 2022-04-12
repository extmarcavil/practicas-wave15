package com.company;

public class Perro extends Animal implements ComeCarne {

    @Override
    public void hacerSonido() {
        System.out.println("El perro hace guau");
    }


    @Override
    public void ComerCarne(Animal a) {
        System.out.println("El perro come carne");
    }
}
