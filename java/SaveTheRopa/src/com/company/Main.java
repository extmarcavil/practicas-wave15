package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        GuardaRopa guardaropa = new GuardaRopa();

        Prenda prenda1 = new Saco("LuisBoton", "Boquita");
        Prenda prenda2 = new Saco("LuisBoton", "River Plato");
        List<Prenda> listaLuis = new ArrayList<Prenda>();
        listaLuis.add(prenda1);
        listaLuis.add(prenda2);

        Prenda prenda3 = new Saco("guchi", "Lemouw");
        Prenda prenda4 = new Saco("guchi", "guruchia");
        List<Prenda> listaguchi = new ArrayList<Prenda>();
        listaguchi.add(prenda3);
        listaguchi.add(prenda4);

        guardaropa.guardarPrendas(listaLuis);
        guardaropa.guardarPrendas(listaguchi);

        for (int i=0; i<=1; i++){
            
        }
        System.out.println("Ingrese una prenda");


        guardaropa.mostrarPrendas();

        System.out.println("Ingrese el numero de la prenda a retirear");
        Scanner teclado = new Scanner(System.in);
        int val =teclado.nextInt();
        List<Prenda> guarda = guardaropa.devolverPrendas(val);


        System.out.println(guarda==null ? "No hay prendas con ese numero" : guarda.toString());

    }
}
