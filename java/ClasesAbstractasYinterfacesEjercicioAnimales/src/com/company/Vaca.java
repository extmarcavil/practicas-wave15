package com.company;

public class Vaca extends Animal implements ComeHierbas{

    @Override
    public void hacerSonido() {
        System.out.println("La vaca hace muuu");
    }

    @Override
    public void ComerHierbas(Animal a) {
        System.out.println("La vaca come hierbas");
    }
}
