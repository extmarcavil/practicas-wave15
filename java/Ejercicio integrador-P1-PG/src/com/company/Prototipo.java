package com.company;

import java.text.NumberFormat;

public abstract class Prototipo <T extends Number>{

    private T initial;
    private T actual;

    public abstract T next();
    public  void reset(){
        actual = initial;
    }
    public void initialValor(T initial){
        this.initial = initial;
    }

    public T getInitial() {
        return initial;
    }

    public void setInitial(T initial) {
        this.initial = initial;
    }

    public T getActual() {
        return actual;
    }

    public void setActual(T actual) {
        this.actual = actual;
    }
}
