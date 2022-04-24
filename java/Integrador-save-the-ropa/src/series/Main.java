package series;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args){

        Prenda pantalon = new Prenda("Koaj", "Pantalón");
        Prenda camisa = new Prenda("Seven21", "Camisa");

        List<Prenda> listaPrendas = new ArrayList<>();
        listaPrendas.add(pantalon);
        listaPrendas.add(camisa);

        System.out.println("**Guardando prendas**");
        GuardaRopa guardaRopa = new GuardaRopa();
        int clave = guardaRopa.guardarPrendas(listaPrendas);
        System.out.println("Clave asignada: " + clave);

        System.out.println("**Reclamando prendas**");
        List<Prenda> prendasReclamadas = guardaRopa.devolverPrendas(clave);

        prendasReclamadas.forEach(System.out::println);

        System.out.println("**Todas las prendas guardadas**");
        guardaRopa.mostrarPrendas();
    }
}
