package com.company;

public class Main {

    public static void main(String[] args) {
        DeADos serie = new DeADos(2);
        Prototipo prototipo = new Prototipo(2) {
            @Override
            public Number increment() {
                return actual;
            }
        };

    }
}
