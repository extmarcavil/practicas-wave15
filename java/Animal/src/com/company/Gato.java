package com.company;

public class Gato extends Animal implements comerCarne{
    String sonido = "miau";

    public Gato(){}

    @Override
    public String toString() {
        return "Gato{" +
                "sonido='" + sonido + '\'' +
                '}';
    }

    public String getSonido() {
        return sonido;
    }

    public void setSonido(String sonido) {
        this.sonido = sonido;
    }

    public Gato(String sonido) {
        this.sonido = sonido;
    }

    @Override
    public String comerCarne() {
        return "Comer carne";
    }
}
