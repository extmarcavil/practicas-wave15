package com.company.clases;

import com.company.interfaces.Carnivoro;

public class Perro extends Animal implements Carnivoro {
    @Override
    public void emitirSonido() {
        System.out.print("GUAUUUU");
    }

    @Override
    public void comerCarne() {
        System.out.print("comiendo carnesita :)");
    }
}
