package com.company;

public class Cat extends Animal implements Carnivorous{
    private String name;

    @Override
    void emitSound() {
        System.out.println("Miau");
    }

    @Override
    public void eatMeat() {
        System.out.println("Eat meat");
    }

    @Override
    boolean isFood() {
        return false;
    }
}
