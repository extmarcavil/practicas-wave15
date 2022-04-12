package com.company.abstracta;

public class Perro extends Animal implements Carnivoro, Comible {

    @Override
    public void emitirSonido() {
        System.out.println("Gua");
    }

    @Override
    public void comerCarne() {
        System.out.println("Comiendo carne");
    }

    @Override
    public void comer() {
        comerCarne();
    }
}
