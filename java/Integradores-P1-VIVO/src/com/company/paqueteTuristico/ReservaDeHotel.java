package com.company.paqueteTuristico;

public class ReservaDeHotel extends PaqueteTuristico {


    /**
     * Constructor
     */
    public ReservaDeHotel(String nombreDeLaReserva) {
        super(nombreDeLaReserva);
    }

    /**
     * Metodos
     */
    @Override
    public double calcularPrecioDeReserva() {
        double precioHabitacion = 1000;
        return precioHabitacion * numeroDeReservas;
    }
}
