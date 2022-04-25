package Integrador2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GuardaRopa gr = new GuardaRopa();

        Prenda prenda1 = new Prenda("Marca1", "Modelo1");
        Prenda prenda2 = new Prenda("Marca1", "Modelo2");

        List<Prenda> listaPrendas = new ArrayList<>();
        listaPrendas.add(prenda1);
        listaPrendas.add(prenda2);

        System.out.println("Guardando prendas...");
        Integer numero = gr.guardarPrendas(listaPrendas);
        System.out.println("Código recibido: " + numero.intValue() + "\n");

        System.out.println("Contenido del GuardaRopa");
        gr.mostrarPrendas();

        System.out.println("Devolución de las prendas");
        List<Prenda> devolucion = gr.devolverPrenda(numero);
        devolucion.stream().forEach(System.out::println);

        System.out.println("\nContenido del GuardaRopa");
        gr.mostrarPrendas();

    }
}
