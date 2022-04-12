package com.company;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class Cliente {
    private int id;
    private ArrayList<Localizador> localizadores = new ArrayList<>();

    public Cliente(int id) {
        this.id = id;
    }

    public void agregarLocalizador(Localizador loc) {
        double costo = 0;

        Set<Producto> productosReservados = new HashSet<Producto>();

        for(Reserva r : loc.obtenerReservas()) {
            loc.costo += r.precio;
            productosReservados.add(r.producto);
        }

        if(this.localizadores.size() > 1)
            loc.costo -= loc.costo * 0.05;

        if(productosReservados.size() == Producto.values().length)
            loc.costo -= loc.costo * 0.1;

        // Faltó esta condición: Si un cliente adquiere 2 reservas de hotel o 2 boletos de viaje, se aplicará un descuento de 5% en esas reservas.
        // Tendría que usar HashMap en vez del HashSet de arriba y guardar para cada producto la cantidad de reservas
        // Luego validar si las de hotel o viaje son >= 2, y si es así aplicar el descuento

        this.localizadores.add(loc);
    }

    public ArrayList<Localizador> obtenerLocalizadores() {
        return this.localizadores;
    }

}
