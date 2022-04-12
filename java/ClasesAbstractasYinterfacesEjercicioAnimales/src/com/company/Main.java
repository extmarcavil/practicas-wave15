package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Animal a = new Animal();
        a.hacerSonido();

        Perro p = new Perro();
        p.hacerSonido();
        p.ComerCarne(a);
        Gato g = new Gato();
        g.hacerSonido();
        g.ComerCarne(a);
        Vaca v = new Vaca();
        v.hacerSonido();
        v.ComerHierbas(a);
    }
}
