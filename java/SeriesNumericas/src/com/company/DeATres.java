package com.company;

public class DeATres extends Prototipo {

    public DeATres(Number inicial) {
        super(inicial);
    }

    @Override
    public Number increment() {
        actual = actual.doubleValue() + 2;

        return actual;
    }

    @Override
    public void reiniciar() {
        super.reiniciar();
        this.actual = inicial;
    }
}
