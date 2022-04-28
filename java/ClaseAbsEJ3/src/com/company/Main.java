package com.company;

import com.company.clases.Animal;
import com.company.clases.Gato;
import com.company.clases.Perro;
import com.company.clases.Vaca;

public class Main {

    public static void main(String[] args) {
        Animal vaca = new Vaca();
        Animal perro = new Perro();
        Animal gato = new Gato();

        vaca.emitirSonido();
        perro.emitirSonido();
        gato.emitirSonido();
    }
}
