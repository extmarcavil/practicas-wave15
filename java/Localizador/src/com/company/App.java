package com.company;

import com.company.model.*;
import com.company.repository.Repositorio;

public class App {

    public static void main(String[] args) {

        Repositorio repo = new Repositorio();

        Cliente cliente = new Cliente("Juan", "40887712");

        ReservaHotel reserva = new ReservaHotel(100);
        Comida comida = new Comida(15);
        Boleto boleto = new Boleto(100);
        Transporte transporte = new Transporte(200);

        Paquete paquete1 = new Paquete();
        paquete1.addBoleto(boleto);
        paquete1.addComida(comida);
        paquete1.addReserva(reserva);
        paquete1.setTransporte(transporte);

        Localizador localizador1 = new Localizador(paquete1, cliente);
        repo.addLocalizador(localizador1);
        System.out.println("Localizador con paquete completo:");
        System.out.println(localizador1);

        Paquete paquete2 = new Paquete();
        paquete2.addReserva(reserva);
        paquete2.addReserva(reserva);
        paquete2.addBoleto(boleto);
        paquete2.addBoleto(boleto);
        Localizador localizador2 = new Localizador(paquete2, cliente);
        repo.addLocalizador(localizador2);
        System.out.println("Localizador con paquete parcial:");
        System.out.println(localizador2);

        Paquete paquete3 = new Paquete();
        paquete3.addReserva(reserva);
        Localizador localizador3 = new Localizador(paquete3, cliente);
        repo.addLocalizador(localizador3);
        System.out.println("Localizador con paquete con una reserva:");
        System.out.println(localizador3);


        System.out.println("Cantidad de localizadores vendidos: " + repo.getTotalLocalizadores());
        System.out.println("Cantidad total de reservas: " + repo.getTotalReservas());
        System.out.println("Diccionario de todas las reservas clasificados por tipo (hotel, boleto,comida,transporte): " + repo.getPaquetesPorTipo());
        System.out.println("Total de ventas: " + repo.getTotalVentas());
        System.out.println("Promedio de todas las ventas: " + repo.getPromedioVentas());
    }
}
