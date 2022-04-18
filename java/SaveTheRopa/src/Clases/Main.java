package Clases;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Prenda> listaPrendas1 = new ArrayList<>();

        listaPrendas1.add(new Prenda("Koaj", "Pantalon"));
        listaPrendas1.add(new Prenda("Pullbear", "Camiseta"));
        listaPrendas1.add(new Prenda("Totto", "Maleta"));

        List<Prenda> listaPrendas2 = new ArrayList<>();

        listaPrendas2.add(new Prenda("Arturo Calle", "Correa"));
        listaPrendas2.add(new Prenda("Gucci", "Chaqueta"));
        listaPrendas2.add(new Prenda("Adidas", "Zapatillas"));

        GuardaRopa guardaRopa = new GuardaRopa();
        guardaRopa.guardarPrendas(listaPrendas1);
        guardaRopa.guardarPrendas(listaPrendas2);

        guardaRopa.mostrarPrendas();

        System.out.println(guardaRopa.devolverPrendas(1));
    }
}
