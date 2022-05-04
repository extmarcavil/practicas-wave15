package model;

public class Serie2 extends Prototipo<Integer>{

    public Serie2() {
        firstNumber = 0;
        number = firstNumber;
    }

    @Override
    public Integer nextValue() {
        number += 2;
        return number;
    }
}
