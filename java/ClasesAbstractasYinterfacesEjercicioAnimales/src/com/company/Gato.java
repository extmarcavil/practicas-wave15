package com.company;

public class Gato extends Animal implements ComeCarne {

    @Override
    public void hacerSonido() {
        System.out.println("El gato hace miau");
    }

    @Override
    public void ComerCarne(Animal a) {
        System.out.println("El gato come carne");
    }
}
