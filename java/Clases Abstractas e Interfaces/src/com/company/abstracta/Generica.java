package com.company.abstracta;

public class Generica <T> {
    public void comerAnimal(T animal){
        if(animal instanceof Gato){
            Gato gato = (Gato) animal;
            gato.comerCarne();
        }

        if(animal instanceof Perro){
            Perro perro = (Perro) animal;
            perro.comerCarne();
        }

        if(animal instanceof Vaca){
            Vaca vaca = (Vaca) animal;
            vaca.comerHierba();
        }
    }
}
