package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here

        Perro perro = new Perro();
        Gato gato = new Gato();
        Vaca vaca = new Vaca();

        /**
         * Ejecutando cada animal
         */
        perro.comerCarne();
        perro.emitirSonido();

        gato.comerCarne();
        gato.emitirSonido();

        vaca.comerHierba();
        vaca.emitirSonido();

        /**
         * Llamando al metodo comerAnimal.
         */
        comerAnimal(vaca);
        comerAnimal(gato);
        comerAnimal(perro);


    }


    public static void comerAnimal(Object animal) {

        if (animal instanceof Perro) {
            ((Perro) animal).comerCarne();
        } else if (animal instanceof Gato) {
            ((Gato) animal).comerCarne();
        } else {
            ((Vaca) animal).comerHierba();
        }

    }
}
