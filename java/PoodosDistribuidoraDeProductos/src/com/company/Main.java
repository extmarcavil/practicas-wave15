package com.company;

import java.util.ArrayList;

public class Main {

   public static void main(String[] args) {

        ArrayList<Producto> productos = new ArrayList<>();

        Producto leche = new Perecedero("leche", 38, 2);
        Producto yogurt = new Perecedero("yogurt", 88, 3);
        Producto pan = new Perecedero("pan", 130, 2);
        Producto queso = new Perecedero("queso", 150, 3);
        Producto manteca = new Perecedero("manteca", 93, 2);
        Producto dulceDeLeche = new Perecedero("dulceDeLeche", 117, 1);

        Producto arroz = new NoPerecedero("arroz", 44, "Arroz");
        Producto fideo = new NoPerecedero("fideo", 80, "Fideos");
        Producto azucar = new NoPerecedero("azucar", 38, "Azucar");
        Producto atun = new NoPerecedero("atun", 105, "atun");
        Producto legunmbres = new NoPerecedero("legumbres", 78, "Legumbres");
        Producto sal = new NoPerecedero("sal", 99, "Sal");

        double precioLeche = leche.calucular(5);
        System.out.println("El precio a vender la leche es: " + precioLeche);
       double precioqueso = queso.calucular(2);
       System.out.println("El precio a vender la queso es: " + precioqueso);

       double precioArroz = arroz.calucular(5);
       System.out.println("El precio a vender la arroz es: " + precioArroz);
       double precioSal = sal.calucular(3);
       System.out.println("El precio a vender la sal es: " + precioSal);

    }
}
