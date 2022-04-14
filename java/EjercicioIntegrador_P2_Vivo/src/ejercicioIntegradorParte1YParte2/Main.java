package ejercicioIntegradorParte1YParte2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Prenda> listaPrendas = new ArrayList<>();
        Prenda prenda1 = new Prenda("Adidas","Modelo1");
        listaPrendas.add(prenda1);
        listaPrendas.add(new Prenda("Nike","Modelo1"));

        List<Prenda> listaPrendas2 = new ArrayList<>();
        listaPrendas2.add(new Prenda("Nike","Modelo2"));
        listaPrendas2.add(new Prenda("Adidas","Modelo2"));

        GuardaRopa guardaRopa1 = new GuardaRopa();
        guardaRopa1.guardarPrendas(listaPrendas);
        guardaRopa1.guardarPrendas(listaPrendas2);

        guardaRopa1.mostarPrendas();
        System.out.println("----------------");
        List<Prenda> prendasDevueltas = guardaRopa1.devolverPrenda(1);
        System.out.println("Prendas devueltas "+prendasDevueltas);
        System.out.println("----------------");
        guardaRopa1.mostarPrendas();
    }
}
