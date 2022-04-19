package integradora;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args){
        Gato gato = new Gato();
        Perro perro = new Perro();
        Vaca vaca = new Vaca();

        gato.emitirSonido();
        gato.comerCarne();

        perro.emitirSonido();
        perro.comerCarne();

        vaca.emitirSonido();
        vaca.comerHierba();

        Comer comer = new Comer();
        comer.comerAnimal(new Gato());
        comer.comerAnimal(new Perro());
        comer.comerAnimal(new Vaca());
    }
}
