package Clases;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        GuardaRopa guardaRopa = new GuardaRopa();

        Prenda jean = new Prenda("Levis", "774");
        Prenda remera = new Prenda("Levis", "Verano");
        Prenda pantalon = new Prenda("Adidas", "Deportivo");
        Prenda camiseta = new Prenda("Adidas", "Futbol");
        Prenda zapatilla = new Prenda("Vans", "Skate");

        List<Prenda> listado = new ArrayList<>();
        listado.add(jean);
        listado.add(remera);
        listado.add(pantalon);
        listado.add(camiseta);
        listado.add(zapatilla);

        List<Prenda> listado1 = new ArrayList<>();
        listado1.add(pantalon);
        listado1.add(camiseta);

        System.out.println(guardaRopa.guardarPrendas(listado));
        System.out.println(guardaRopa.guardarPrendas(listado1));

        guardaRopa.mostrarPrendas();

        guardaRopa.devolverPrenda(1);

        guardaRopa.mostrarPrendas();
    }
}
