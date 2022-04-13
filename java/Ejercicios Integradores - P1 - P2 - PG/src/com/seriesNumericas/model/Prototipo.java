package com.seriesNumericas.model;

public abstract class Prototipo <T extends Number> {
    private T valorInicial;
    private double valorSiguiente;
    private T serie;

    public void setSerie(T serie) {
        this.serie = serie;
    }

    public double siguienteValor(){
        if(valorSiguiente == 0){
            if(valorInicial == null){
                valorSiguiente = serie.doubleValue();
            } else {
                valorSiguiente = valorInicial.doubleValue() + serie.doubleValue();
            }
        } else{
            valorSiguiente += serie.doubleValue();
        }

        return valorSiguiente;
    }

    public void reiniciarSerie(){
        valorSiguiente = 0;
    }

    public void valorInicial(T valor){
        this.valorInicial = valor;
    }

    @Override
    public String toString() {
        return "Prototipo{" +
                "valorInicial=" + valorInicial +
                ", valorSiguiente=" + valorSiguiente +
                ", serie=" + serie +
                '}';
    }
}
