package com.company.clases;

import com.company.interfaces.Herviboro;

public class Vaca extends Animal implements Herviboro {
    @Override
    public void emitirSonido() {
        System.out.print("MUUUUUUU");
    }

    @Override
    public void comerHierba() {
        System.out.print("comiendo pastito rico!!!");
    }
}
