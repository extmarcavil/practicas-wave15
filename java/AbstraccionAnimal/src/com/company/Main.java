package com.company;

import com.company.animales.Gato;
import com.company.animales.Perro;
import com.company.animales.Vaca;

public class Main {

    public static void main(String[] args) {

        Animal caniche = new Perro("chichito");
        caniche.hacerSonido();
        caniche.tipo();

        System.out.println("---------------");

        Animal angora = new Gato("Michi");
        angora.hacerSonido();
        angora.tipo();

        System.out.println("----------------");

        Animal angus = new Vaca("lola");
        angus.hacerSonido();
        angus.tipo();
    }
}
