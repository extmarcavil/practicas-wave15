package EjerciciosIntegradores.SaveTheRopa;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        GuardaRopa guardaRopa = new GuardaRopa();

        List<Prenda> prendaA = new ArrayList<>();
        prendaA.add(new Prenda("Nike", "SB Court Model"));
        System.out.println("Ticket: " + guardaRopa.guardarPrendas(prendaA));

        List<Prenda> prendaB = new ArrayList<>();
        prendaB.add(new Prenda("Vans", "Low Cut"));
        prendaB.add(new Prenda("Wrangler", "Jeans"));
        prendaB.add(new Prenda("North Face", "Rompeviento"));
        System.out.println("Ticket: " + guardaRopa.guardarPrendas(prendaB));

        List<Prenda> prendaC = new ArrayList<>();
        prendaC.add(new Prenda("Pampero", "Paraguas"));
        prendaB.add(new Prenda("Cardon", "Botas"));
        System.out.println("Ticket: " + guardaRopa.guardarPrendas(prendaC));

        System.out.println("Prendas guardadas: ");
        guardaRopa.mostrarPrendas();

        System.out.println("Prenda Devuelta: ");
        System.out.println(guardaRopa.devolverPrendas(1));

        System.out.println("Prendas guardadas: ");
        guardaRopa.mostrarPrendas();
    }
}
