package com.company.santiagopinzondev;

public class Clase1<T> extends Prototipo<T>{

    T valorInicial;
    T serie;

    @Override
    public void comenzarSerie() {
        serie = serie + valorInicial;
        System.out.println(serie);
    }

    @Override
    public void resetSerie() {
        serie = valorInicial;
        System.out.println(serie);
    }

    @Override
    public void SetValor(T number) {
        valorInicial = number;
    }
}
