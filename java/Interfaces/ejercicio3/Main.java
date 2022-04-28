package abstractasInterfaces.ejercicio3;

import abstractasInterfaces.ejercicio3.entity.Animal;
import abstractasInterfaces.ejercicio3.entity.Gato;
import abstractasInterfaces.ejercicio3.entity.Perro;
import abstractasInterfaces.ejercicio3.entity.Vaca;
import abstractasInterfaces.ejercicio3.services.impl.EatService;

public class Main {

    public static void main (String[] args) {
        Animal perro = new Perro();
        Animal gato = new Gato();
        Animal vaca = new Vaca();

        perro.sound();
        gato.sound();
        vaca.sound();

        EatService.comerAnimal(perro);
        EatService.comerAnimal(gato);
        EatService.comerAnimal(vaca);
    }
}
