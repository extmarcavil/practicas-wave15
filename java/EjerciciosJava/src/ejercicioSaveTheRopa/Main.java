package ejercicioSaveTheRopa;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Prenda prenda1 = new Prenda("Nike", "Remera");
        Prenda prenda2 = new Prenda("Reebook", "Medias");
        Prenda prenda3 = new Prenda("Reebook", "Zapatillas");

        GuardaRopa gr = new GuardaRopa();

        List<Prenda> lista1 = new ArrayList<>();
        lista1.add(prenda1);
        lista1.add(prenda2);

        System.out.println("Prendas guardadas en el casillero: " + gr.guardarPrendas(lista1) + "\n");


        List<Prenda> lista2 = new ArrayList<>();
        lista2.add(prenda3);

        System.out.println("Prendas guardadas en el casillero: " + gr.guardarPrendas(lista2) + "\n");

        gr.mostrarPrendas();

        System.out.println("\nLista prendas devueltas: \n" + gr.devolverPrendas(1) + "\n");

        gr.mostrarPrendas();
    }
}
