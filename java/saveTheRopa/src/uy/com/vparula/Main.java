package uy.com.vparula;

import uy.com.vparula.Prenda;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Prenda prenda1 = new Prenda("Nike", "shirt");
        Prenda prenda2 = new Prenda("adidas", "shoes");
        GuardaRopa guardaRopa = new GuardaRopa();
        List<Prenda> prendas = new ArrayList<>();
        prendas.add(prenda1);
        prendas.add(prenda2);
        guardaRopa.guardaRopa(prendas);

        prendas.clear();

        guardaRopa.mostrarPrendas();
        List<Prenda> prendas2 = new ArrayList<>();
        prendas2.add(prenda2);
        prendas2.add(prenda2);
        guardaRopa.guardaRopa(prendas2);
        guardaRopa.mostrarPrendas();

        System.out.println(guardaRopa.devolverPrendas(2));

    }
}
