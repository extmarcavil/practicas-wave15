package abstractasInterfaces.ejercicio3.entity;

import abstractasInterfaces.ejercicio3.services.Eat;
import abstractasInterfaces.ejercicio3.services.impl.EatService;

public class Gato extends Animal {

    Eat eatService;

    public Gato() {
        this.eatService = new EatService();
    }

    @Override
    public void eat() {
        this.eatService.eatMeat();
    }

    @Override
    public void sound() {
        System.out.println("Miau");
    }
}
