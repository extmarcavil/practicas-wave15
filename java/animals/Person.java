package com.company;

public class Person {
    public void eatAnimal(Animal animal) {
        if (animal.isFood()) {
            System.out.println("I'm eating " + animal.getClass().getSimpleName());
        } else {
            System.out.println("I don't eat " + animal.getClass().getSimpleName());
        }
    }
}
