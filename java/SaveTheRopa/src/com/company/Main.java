package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Prenda camisa = new Prenda("Gucci","camiseta");
        Prenda pantalon = new Prenda("Gucci","pantalon");
        List<Prenda> ropa= new ArrayList<>();
        ropa.add(camisa);
        ropa.add(pantalon);
        GuardaRopa guardaRopa = new GuardaRopa();
        guardaRopa.guardarPrendas(ropa);
        guardaRopa.toString();

    }
}
