package main;

import entitiy.GuardaRopa;
import entitiy.Prenda;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GuardaRopa guardaRopa = new GuardaRopa();

        Prenda prenda1 = new Prenda("Marquita","Modelito");
        Prenda prenda2 = new Prenda("Marcota","Modelote");

        ArrayList<Prenda> lista1 = new ArrayList<>();
        lista1.add(prenda1);
        lista1.add(prenda2);

        guardaRopa.mostrarPrendas();

        Integer ticket1 = guardaRopa.guardarPrendas(lista1);
        System.out.println("Creamos el ticket " + ticket1);

        guardaRopa.mostrarPrendas();

        ArrayList<Prenda> lista2 = new ArrayList<>();
        lista2.add(prenda1);

        Integer ticket2 = guardaRopa.guardarPrendas(lista2);
        System.out.println("Creamos el ticket " + ticket2);

        guardaRopa.mostrarPrendas();

        List<Prenda> prendasDevueltas =  guardaRopa.devolverPrendas(1);
        if(prendasDevueltas == null){
            System.out.println("No se encontraron prendas con ese ticket");
            return;
        }

        System.out.println("Prendas devueltas");
        prendasDevueltas.forEach(System.out::println);
    }
}
