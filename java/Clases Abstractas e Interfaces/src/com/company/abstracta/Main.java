package com.company.abstracta;

public class Main {

    public static void main(String[] args) {
        Gato gato = new Gato();
        gato.emitirSonido();
        gato.comerCarne();

        comerAnimal(gato);

        Perro perro = new Perro();
        perro.emitirSonido();
        perro.comerCarne();

        comerAnimal(perro);

        Vaca vaca = new Vaca();
        vaca.emitirSonido();
        vaca.comerHierba();

        comerAnimal(vaca);

        Generica generica = new Generica();
        generica.comerAnimal(gato);
        generica.comerAnimal(perro);
        generica.comerAnimal(vaca);

    }

    public static void comerAnimal(Comible comible){
        comible.comer();
    }
}
