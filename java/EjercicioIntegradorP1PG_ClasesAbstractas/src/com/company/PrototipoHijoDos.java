package com.company;

public class PrototipoHijoDos extends  Prototipo<Double> {

    public PrototipoHijoDos(Double valorSerie) {
        super(valorSerie);
        this.valorActual = 0.0;
    }

    @Override
    public Double valorSiguiente() {
        return valorActual += valorSerie;
    }

    @Override
    public void reiniciarSerie() {
        valorActual = 0.0;
    }
}

