package com.company.paqueteTuristico;

public class Transporte extends PaqueteTuristico {


    /**
     * Constructor
     */
    public Transporte(String nombreDeLaReserva) {
        super(nombreDeLaReserva);
    }

    /**
     * Metodos
     */
    @Override
    public double calcularPrecioDeReserva() {
        double precioDelPasaje = 100;
        return numeroDeReservas * precioDelPasaje;
    }
}
