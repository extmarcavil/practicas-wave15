package com.company;

public class Main {

    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        Cow cow = new Cow();

        dog.emitSound();
        cat.emitSound();
        cow.emitSound();

        Person person = new Person();

        person.eatAnimal(dog);
        person.eatAnimal(cat);
        person.eatAnimal(cow);
    }
}
