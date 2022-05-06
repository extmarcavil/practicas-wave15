package com.company;

public class Perro extends Animal implements AlimentoCarnivoros {

    @Override
    public void comerCarne() {
        System.out.println("Me alimento de Carne");
    }

    @Override
    public void emitirSonido() {
        System.out.println(" !Guau Guauu¡");
    }


}
