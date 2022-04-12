package com.company.abstracta;

public class Vaca extends Animal implements Herviboro, Comible{

    @Override
    public void emitirSonido() {
        System.out.println("Muu");
    }

    @Override
    public void comerHierba() {
        System.out.println("Comiendo pastito");
    }

    @Override
    public void comer() {
        comerHierba();
    }
}
