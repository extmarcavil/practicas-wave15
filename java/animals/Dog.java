package com.company;

    public class Dog extends Animal implements Carnivorous{
        private String name;

        @Override
        void emitSound() {
            System.out.println("Guau");
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

