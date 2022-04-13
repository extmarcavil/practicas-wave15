package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Repositorio repo = new Repositorio();

        Cliente cliente = new Cliente("Juan", "40887712");

        ReservaHotel reserva = new ReservaHotel(100);
        Comida comida = new Comida(15);
        Boleto boleto = new Boleto(100);
        Transporte transporte = new Transporte(100);

        ReservaHotel reservaTwo = new ReservaHotel(250);
        Comida comidaTwo = new Comida(341);
        Boleto boletoTwo = new Boleto(60);


        ArrayList<Comida> comidas = new ArrayList<>();
        ArrayList<Boleto> boletos = new ArrayList<>();
        ArrayList<ReservaHotel> reservas = new ArrayList<>();

        comidas.add(comida);
        comidas.add(comidaTwo);
        reservas.add(reserva);
        reservas.add(reservaTwo);
        boletos.add(boletoTwo);
        boletos.add(boleto);

        Paquete paquete1 = new Paquete();
        paquete1.setBoleto(boletos);
        paquete1.setComida(comidas);
        paquete1.setReserva(reservas);
        paquete1.setTransporte(transporte);

        Localizador localizador = new Localizador(paquete1, cliente);


    }
}
