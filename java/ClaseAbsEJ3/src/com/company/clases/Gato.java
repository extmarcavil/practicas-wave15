package com.company.clases;

import com.company.interfaces.Carnivoro;

public class Gato extends Animal implements Carnivoro {
    @Override
    public void emitirSonido() {
        System.out.print("MIAAAAAU");
    }

    @Override
    public void comerCarne() {
        System.out.print("comiendo carnesita :)");
    }
}
