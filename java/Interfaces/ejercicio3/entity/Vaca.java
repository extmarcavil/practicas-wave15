package abstractasInterfaces.ejercicio3.entity;

import abstractasInterfaces.ejercicio3.services.Eat;
import abstractasInterfaces.ejercicio3.services.impl.EatService;

public class Vaca extends Animal {

    Eat eatService;

    public Vaca() {
        this.eatService = new EatService();
    }

    @Override
    public void eat() {
        this.eatService.eatGrass();
    }

    @Override
    public void sound() {
        System.out.println("MUUUU");
    }
}
