package com.company;

public class Vaca extends Animal implements comerHierba{
    String sonido = "muuu";

    public Vaca(){}

    @Override
    public String toString() {
        return "Vaca{" +
                "sonido='" + sonido + '\'' +
                '}';
    }

    public String getSonido() {
        return sonido;
    }

    public void setSonido(String sonido) {
        this.sonido = sonido;
    }

    public Vaca(String sonido) {
        this.sonido = sonido;
    }

    @Override
    public String comerHierba() {
        return "Come pasto";
    }
}
