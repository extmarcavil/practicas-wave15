package Ejercicio3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Gato gato = new Gato();
        Perro perro = new Perro();
        Vaca vaca = new Vaca();

        List<Animal> animales = new ArrayList<>();

        animales.add(gato);
        animales.add(perro);
        animales.add(vaca);

        animales.forEach(Animal::emitirSonido);

        gato.comerCarne();
        perro.comerCarne();
        vaca.comerHierba();
    }
}
