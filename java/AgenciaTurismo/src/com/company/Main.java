package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    Cliente c = new Cliente(1);

        // Punto 1
        ArrayList<Reserva> reservas = new ArrayList<>();
        reservas.add(new Reserva(Producto.HOTEL, 100));
        reservas.add(new Reserva(Producto.VIAJE, 100));
        reservas.add(new Reserva(Producto.TRANSPORTE, 100));
        reservas.add(new Reserva(Producto.COMIDA, 100));
        Localizador l = new Localizador(reservas);

        c.agregarLocalizador(l);

        // Punto 2
        ArrayList<Reserva> reservas2 = new ArrayList<>();
        reservas2.add(new Reserva(Producto.HOTEL, 100));
        reservas2.add(new Reserva(Producto.HOTEL, 100));
        reservas2.add(new Reserva(Producto.VIAJE, 100));
        reservas2.add(new Reserva(Producto.VIAJE, 100));

        c.agregarLocalizador(new Localizador(reservas2));

        // Punto 3
        Localizador l3 = new Localizador(new ArrayList<Reserva>(List.of(new Reserva(Producto.HOTEL, 100))));
        c.agregarLocalizador(l3);

        // Punto 4 - Calcular el precio del localizador anterior y verificar que se hayan aplicado el descuento
        System.out.println(l3.costo);
    }
}
