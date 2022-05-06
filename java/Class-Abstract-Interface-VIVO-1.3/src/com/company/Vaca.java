package com.company;

public class Vaca extends Animal implements AlimnetoHervivoro{
    @Override
    public void comerHierba() {
        System.out.println("Me alimento de Hierbas");
    }

    @Override
    public void emitirSonido() {
        System.out.println(" !Muuuuuu¡");
    }
}
