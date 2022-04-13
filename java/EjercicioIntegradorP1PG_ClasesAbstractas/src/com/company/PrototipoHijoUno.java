package com.company;

public class PrototipoHijoUno extends Prototipo<Integer> {

    public PrototipoHijoUno(Integer valorSerie) {
        super(valorSerie);
        this.valorActual = 0;
    }

    @Override
    public Integer valorSiguiente() {
        return valorActual += valorSerie;
    }

    @Override
    public void reiniciarSerie() {
        valorActual = 0;
    }
}
