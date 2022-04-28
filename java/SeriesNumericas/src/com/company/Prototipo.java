package com.company;

public abstract class Prototipo <T extends Number> {
    T inicial;
    T actual;
    T siguiente;

    public Prototipo(){}

    public Prototipo(T inicial) {
        this.inicial = inicial;
    }

    public abstract T increment();

    public void reiniciar(){
        actual = inicial;
    }


}
