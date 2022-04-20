package com.company.model;

import com.company.model.paqueteTuristico.Reserva;

import java.util.ArrayList;

public class Descuento {
    public Descuento(){
    }


    public double calcularDescuento(Cliente cliente, ArrayList<Localizador> listaLocalizadores, double montoTotal){
        String tipoDescuento = ""; //"5% a futuro por dos localizadores(DESCUENTO-1), 10% por paquete completo(DESCUENTO-2), 5% por 2 reservas de hotel o 2 reservas de boletos de viaje(DESCUENTO-3)"
        Cliente clienteAuxiliar;
        ArrayList<Reserva> listaReserva = new ArrayList<Reserva>();
        boolean descuentoAplicado = false;
        int cantidadReservasBoletoViaje = 0;
        int cantidadReservasComida = 0;
        int cantidadReservasHotel = 0;
        int cantidadReservasTransporte = 0;
        double montoTotalAuxiliar = 0;

        //(DESCUENTO-1)
        int cantLocalizadores = 0;
        for(Localizador localizador : listaLocalizadores){
            clienteAuxiliar = localizador.getCliente();
            if (clienteAuxiliar == cliente){
                ++cantLocalizadores;
                montoTotalAuxiliar = montoTotalAuxiliar + localizador.getMontoTotal();
            }
        }
        if(cantLocalizadores == 2 ){
            tipoDescuento = "(DESCUENTO-1)";
            montoTotalAuxiliar = montoTotalAuxiliar - (montoTotalAuxiliar * 0.05);
            montoTotal = montoTotalAuxiliar;
            return montoTotal;
        }

        //(DESCUENTO-2)
        montoTotalAuxiliar = 0;
        for(Localizador localizador : listaLocalizadores){
            clienteAuxiliar = localizador.getCliente();
            if (clienteAuxiliar == cliente){
                listaReserva = localizador.getListaReservas();
                for(Reserva reserva : listaReserva){
                    if (reserva.getClass().getName() == "BoletoViaje") {
                        ++cantidadReservasBoletoViaje;
                        montoTotalAuxiliar = montoTotalAuxiliar + reserva.getMonto();
                    }
                    if (reserva.getClass().getName() == "Comida") {
                        ++cantidadReservasComida;
                        montoTotalAuxiliar = montoTotalAuxiliar + reserva.getMonto();
                    }
                    if (reserva.getClass().getName() == "Hotel") {
                        ++cantidadReservasHotel;
                        montoTotalAuxiliar = montoTotalAuxiliar + reserva.getMonto();
                    }
                    if (reserva.getClass().getName() == "Transporte") {
                        ++cantidadReservasTransporte;
                        montoTotalAuxiliar = montoTotalAuxiliar + reserva.getMonto();
                    }
                }
            }
        }
        if(cantidadReservasBoletoViaje > 0 && cantidadReservasComida > 0 && cantidadReservasHotel > 0 && cantidadReservasTransporte > 0){
            tipoDescuento = "(DESCUENTO-2)";
            montoTotalAuxiliar = montoTotalAuxiliar - (montoTotalAuxiliar * 0.10);
            montoTotal = montoTotalAuxiliar;
            return montoTotal;
        }

        //(DESCUENTO-3)
        if (cantidadReservasBoletoViaje == 2 && cantidadReservasHotel == 2){
            tipoDescuento = "(DESCUENTO-3)";
            montoTotalAuxiliar = montoTotalAuxiliar - (montoTotalAuxiliar * 0.05);
            montoTotal = montoTotalAuxiliar;
            return montoTotal;
        }

        return montoTotal;
    }
}
