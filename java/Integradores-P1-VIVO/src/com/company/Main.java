package com.company;

import com.company.agenciaDeTurismo.AgenciaDeTurismo;
import com.company.paqueteTuristico.*;

public class Main {

    public static void main(String[] args) {
        // write your code here

        /**
         * Creando cada tipo de reserva disponible en la agencia de Turismo.
         * Por default la cantidad de reservas para cada producto es 1.
         */
        PaqueteTuristico reservaDeHotel = new ReservaDeHotel("reserva de hotel");
        PaqueteTuristico comida = new Comida("reserva de comida");
        PaqueteTuristico boletosDeViaje = new BoletoDeViaje("reserva de boletos");
        PaqueteTuristico transporte = new Transporte("reserva de transporte");


        /**
         * Creando mi cliente con todas las reservas disponibles por la agencia de Turismo
         */
        Cliente pedro = new Cliente("Pedro", "Perez", 1234);
        //Le seteo cada una de las reservas que desea el cliente.
        pedro.addReserva(reservaDeHotel);
        pedro.addReserva(comida);
        pedro.addReserva(boletosDeViaje);
        pedro.addReserva(transporte);

        //Segundo localizador adquirido por Pedro.
        Cliente pedro1 = new Cliente("Pedro", "Perez", 1234);
        //Le seteo cada una de las reservas que desea el cliente.
        reservaDeHotel.setNumeroDeReservas(2);
        boletosDeViaje.setNumeroDeReservas(2);
        pedro1.addReserva(reservaDeHotel);
        pedro1.addReserva(boletosDeViaje);

        //Tercer Localizador adquirido por pedro
        Cliente pedro2 = new Cliente("Pedro", "Perez", 1234);
        //Agregando reservas
        reservaDeHotel.setNumeroDeReservas(1);
        boletosDeViaje.setNumeroDeReservas(1);
        pedro2.addReserva(reservaDeHotel);


        /**
         * Creando mi localizador con la informacion del cliente y las reservas hechas.
         */
        Localizador localizadorPedro = new Localizador(pedro.getReservasHechas(), pedro);
        Localizador localizadorPedro1 = new Localizador(pedro1.getReservasHechas(), pedro1);
        Localizador localizadorPedro2 = new Localizador(pedro2.getReservasHechas(), pedro2);


        /**
         * Creando mi agencia de Turismo
         */
        System.out.println("Creo mi Agencia de turismo" + "\n");
        AgenciaDeTurismo weekend = new AgenciaDeTurismo();

        /**
         *Proband los descuentos generados por la agencia de Turismo
         * Con un paquete Turistico completo descuento 10%
         */
        System.out.println(weekend.descuentos(localizadorPedro, localizadorPedro.getCliente()));

        /**
         * Probando con un localizador con 2 reservas de hotel o boletos para el mismo cliente anterior.
         */
        System.out.println(weekend.descuentos(localizadorPedro1, localizadorPedro1.getCliente()));


        /**
         *Probando con un localizado al mismo cliente y una sola reserva
         */
        System.out.println(weekend.descuentos(localizadorPedro2, localizadorPedro2.getCliente()));
    }
}
