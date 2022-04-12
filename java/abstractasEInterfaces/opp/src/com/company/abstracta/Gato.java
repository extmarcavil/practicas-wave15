package com.company.abstracta;

public class Gato extends Animal implements Carnivoro, Comible {


    @Override
    public void emitirSonido() {
        System.out.println("Miau");
    }

    @Override
    public void comerCarne() {
        System.out.println("Comiendo pescado");
    }

    @Override
    public void comer() {
        comerCarne();
    }
}
