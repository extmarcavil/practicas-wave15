package com.company;

public class DeADos extends Prototipo{

    public DeADos(Number inicial) {
        super(inicial);
    }

    @Override
    public Number increment() {
        actual = actual.doubleValue() + 2;

        return actual;
    }
}
