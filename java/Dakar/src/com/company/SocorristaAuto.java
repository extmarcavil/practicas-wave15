package com.company;

public class SocorristaAuto extends Socorrista {
    @Override
    public void socorrer( String patente) {
        System.out.println("Socorriendo auto " + patente);
    }
}
