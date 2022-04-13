package main;

public class Perro extends Animal implements Carnivoro{

    @Override
    public void hacerRuido() {
        System.out.println("Guau");
    }
}
