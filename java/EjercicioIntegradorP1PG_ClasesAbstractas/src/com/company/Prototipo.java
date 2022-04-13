package com.company;

public abstract class Prototipo <T extends Number> {

    protected T valorSerie;
    protected T valorActual;

    public Prototipo(T valorSerie) {
        this.valorSerie = valorSerie;
    }

    public void iniciarSerie(T valorInicial){
        this.valorActual = valorInicial;
    }
    //número que corresponderá al valor siguiente a la serie progresiva.
    public abstract T valorSiguiente();
    // Otro método para reiniciar la serie, y
    public abstract void reiniciarSerie();

    // un último que recibirá un valor que servirá para establecer el valor inicial de la serie.
   // public abstract Double reestablecerValor(Double valor);
    // Las clases deben estar preparadas para recibir cualquier tipo de dato numérico no primitivo.

}
