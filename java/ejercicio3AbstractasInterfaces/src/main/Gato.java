package main;

public class Gato extends Animal implements Carnivoro{

    @Override
    public void hacerRuido() {
        System.out.println("Miau");
    }
}
