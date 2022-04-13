package lavanderia;

import lavanderia.GuardaRopa;
import lavanderia.Prenda;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        GuardaRopa guardaRopa = new GuardaRopa();

        Prenda prenda = new Prenda("Nike", "Remera");
        Prenda prenda2 = new Prenda("Adidas", "Campera");

        int codigoPrenda = guardaRopa.guardarPrendas(List.of(prenda));
        int codigoPrenda2 = guardaRopa.guardarPrendas(List.of(prenda2));

        System.out.println(guardaRopa.devolverPrendas(codigoPrenda));
        System.out.println(guardaRopa.devolverPrendas(codigoPrenda2));
        System.out.println(guardaRopa.devolverPrendas(222));
        guardaRopa.mostrarPrendas();
    }
}
