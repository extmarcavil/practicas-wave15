package com.company;

public class Perro extends Animal implements comerCarne{
    String sonido = "guau";

    public Perro(){}

    @Override
    public String toString() {
        return "Perro{" +
                "sonido='" + sonido + '\'' +
                '}';
    }

    public String getSonido() {
        return sonido;
    }

    public void setSonido(String sonido) {
        this.sonido = sonido;
    }

    public Perro(String sonido) {
        this.sonido = sonido;
    }

    @Override
    public String comerCarne() {
        return "Come carne";
    }
}
