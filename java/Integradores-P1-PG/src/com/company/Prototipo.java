package com.company;

public abstract class Prototipo<T extends Number> {

    protected T serie;
    protected T inicioDeSerie;

    /**
     * Valor Siguiente
     */
    public abstract void valorSigueinteSerie();

    /**
     * Reiniciar Serie
     */
    public abstract void Reiniciar();

    /**
     * Valor inicial de la serie.
     */
    public abstract void establecerValorIncialSerie(T valorInicial);


    /**
     * Getter & Setter
     */
    public void setSerie(T serie) {
        this.serie = serie;
    }
}
