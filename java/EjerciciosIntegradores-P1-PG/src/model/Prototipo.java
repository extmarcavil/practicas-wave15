package model;

public abstract class Prototipo<T extends Number>{
    protected T firstNumber;
    protected T number;
    public abstract T nextValue();
    public void resetSerie(){
        number = firstNumber;
    }
    public void initSerie(T number){
        this.firstNumber = number;
        this.number = this.firstNumber;
    }
}
