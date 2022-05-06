package com.company;

public interface Imprimible<T> {

    /**
     * Usando mi metodo por Default en la interfaz.
     */
    default void imprimirDocumento(){
        //System.out.println("Imprimiendo Documento");
    }
}
