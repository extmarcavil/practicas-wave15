package abstractasInterfaces.ejercicio3.services.impl;

import abstractasInterfaces.ejercicio3.entity.Animal;
import abstractasInterfaces.ejercicio3.services.Eat;

public class EatService implements Eat {

    @Override
    public void eatMeat() {
        System.out.println("Comiendo Carne");
    }

    @Override
    public void eatGrass() {
        System.out.println("Comiendo Hierba");
    }

    public static void comerAnimal(Animal animal) {
        animal.eat();
    }
}
