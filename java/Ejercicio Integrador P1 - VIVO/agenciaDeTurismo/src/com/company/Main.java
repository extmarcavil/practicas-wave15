package com.company;

import com.company.model.*;
import com.company.model.paqueteTuristico.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        //Parte 1
        ArrayList<Localizador> listaLocalizadores = new ArrayList<Localizador>();
        ArrayList<Reserva> listaReservas1 = new ArrayList<Reserva>();
        Descuento descuento = new Descuento();
        double montoTotal = 0;
        Cliente cliente = new Cliente("33036945", "Matias", "Alvarez");

        BoletoViaje boletoViaje1 = new BoletoViaje(cliente, 1234.58, "Rìo Cuarto", "Cordoba");
        listaReservas1.add(boletoViaje1);

        Comida comida1 = new Comida(cliente, 599.66, "Sushi");
        listaReservas1.add(comida1);

        Hotel hotel1 = new Hotel(cliente, 3000, "Hotel Palacios", "San Lorenzo 111");
        listaReservas1.add(hotel1);

        Transporte transporte1 = new Transporte(cliente, 200, "El Rapido", "Rìo Cuarto", "Cordoba");
        listaReservas1.add(transporte1);

        Localizador localizador1 = new Localizador(cliente, listaReservas1);
        listaLocalizadores.add(localizador1);

        montoTotal = calcularMontoTotal(listaLocalizadores);
        montoTotal = descuento.calcularDescuento(cliente, listaLocalizadores, montoTotal);

        //imprimirLocalizador(cliente, listaLocalizadores);

        //Parte 2
        ArrayList<Reserva> listaReservas2 = new ArrayList<Reserva>();
        BoletoViaje boletoViaje2 = new BoletoViaje(cliente, 1000, "Cordoba", "Rìo Cuarto");
        listaReservas2.add(boletoViaje2);
        BoletoViaje boletoViaje3 = new BoletoViaje(cliente, 2000, "Achiras", "San Basilio");
        listaReservas2.add(boletoViaje3);

        Hotel hotel2 = new Hotel(cliente, 4000, "Hotel Los Pirinchos", "Cuenca 2123");
        listaReservas2.add(hotel2);
        Hotel hotel3 = new Hotel(cliente, 1000, "El Pobrecito", "Los Reartes 222");
        listaReservas2.add(hotel3);

        Localizador localizador2 = new Localizador(cliente, listaReservas2);
        listaLocalizadores.add(localizador2);

        montoTotal = calcularMontoTotal(listaLocalizadores);
        montoTotal = descuento.calcularDescuento(cliente, listaLocalizadores, montoTotal);


        imprimirLocalizador(cliente, listaLocalizadores);
    }

    private static void imprimirLocalizador(Cliente cliente, ArrayList<Localizador> listaLocalizadores) {
        for(Localizador localizador : listaLocalizadores){
            System.out.println("--------------------------------------------------------------");
            System.out.println(localizador.toString());
        }
    }
    private static double calcularMontoTotal(ArrayList<Localizador> listaLocalizadores){
        double montoTotal = 0;

        for(Localizador localizador : listaLocalizadores){
            montoTotal = montoTotal + localizador.getMontoTotal();
        }
        return montoTotal;
    }
}
