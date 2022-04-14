package com.company;

public class SocorristaMoto extends Socorrista {
    @Override
    public void socorrer(String patente) {
        System.out.println("Socorriendo moto" + patente);
    }
}
