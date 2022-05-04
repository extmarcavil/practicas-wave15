package model;

public class Serie3 extends Prototipo<Integer>{

    public Serie3() {
        firstNumber = 0;
        number = this.firstNumber;
    }

    @Override
    public Integer nextValue() {
        number += 3;
        return number;
    }

}
