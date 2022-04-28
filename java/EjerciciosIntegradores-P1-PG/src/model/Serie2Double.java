package model;

public class Serie2Double extends Prototipo<Double>{

    public Serie2Double() {
        firstNumber = 0d;
        number = firstNumber;
    }

    @Override
    public Double nextValue() {
        number += 2.5;
        return number;
    }
}
