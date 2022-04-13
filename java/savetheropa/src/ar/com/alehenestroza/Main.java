package ar.com.alehenestroza;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        GuardaRopa guardaRopa = new GuardaRopa();
        List<Prenda> prendas = new ArrayList<>();

        prendas.add(new Prenda("Levis", "Saco"));
        prendas.add(new Prenda("Adidas", "Buzo"));

        Integer numeroPrendas = guardaRopa.guardarPrendas(prendas);
        guardaRopa.mostrarPrendas();

        System.out.println("Se retiran las prendas con el numero " + numeroPrendas);

        System.out.println(guardaRopa.devolverPrendas(numeroPrendas));
    }
}
