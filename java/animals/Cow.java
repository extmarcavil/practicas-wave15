package com.company;

public class Cow extends Animal implements Carnivorous{
    private String name;

    @Override
    void emitSound() {
        System.out.println("Muuu");
    }

    @Override
    public void eatMeat() {
        System.out.println("Don't eat meat");
    }

    @Override
    boolean isFood() {
        return true;
    }
}
