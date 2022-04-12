package Ejercicio3;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        ArrayList<Animal> animales = new ArrayList<>(Arrays.asList(new Perro(), new Gato(), new Vaca()));

        for (Animal animal : animales) {
            animal.emitirSonido();
            animal.comer();
        }
    }
}
