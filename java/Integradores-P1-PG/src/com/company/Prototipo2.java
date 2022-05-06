package com.company;

public class Prototipo2 extends Prototipo<Integer> {

    /**
     * constructor
     */
    public Prototipo2() {
        inicioDeSerie = 0;
    }

    /**
     * Metodos
     */
    @Override
    public void establecerValorIncialSerie(Integer valorInicial) {
        this.inicioDeSerie = valorInicial;
    }

    @Override
    public void valorSigueinteSerie() {

        for (int i = 0; i < serie; i++) {
            inicioDeSerie += 1;
        }
        System.out.println(inicioDeSerie);
    }

    @Override
    public void Reiniciar() {
        inicioDeSerie = 0;
    }

}
