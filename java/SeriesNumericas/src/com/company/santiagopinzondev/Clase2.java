package com.company.santiagopinzondev;

public class Clase2<T> extends Prototipo<T>{
    T valorInicial;
    Integer serie;

    @Override
    public void comenzarSerie() {
        serie = Integer.valueOf((Integer) valorInicial) + Integer.valueOf((Integer) serie);
        System.out.println(serie);
    }

    @Override
    public void resetSerie() {
        serie = Integer.valueOf((Integer) valorInicial);
        System.out.println(serie);
    }

    @Override
    public void SetValor(T number) {
        valorInicial = number;
    }
}
