package com.company;

public class Prototipo1 extends Prototipo<Double> {


    /**
     * constructor
     */
    public Prototipo1() {
        inicioDeSerie = 0.0;
    }

    /**
     * Metodos
     */
    @Override
    public void establecerValorIncialSerie(Double valorInicial) {
        this.inicioDeSerie = valorInicial;
    }

    @Override
    public void valorSigueinteSerie() {

        for (int i = 0; i <serie ; i++) {
            inicioDeSerie += 1;
        }
        System.out.println(inicioDeSerie);
    }

    @Override
    public void Reiniciar() {
        inicioDeSerie = 0.0;
    }


}
