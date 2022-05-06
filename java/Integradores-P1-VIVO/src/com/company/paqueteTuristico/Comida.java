package com.company.paqueteTuristico;

public class Comida extends PaqueteTuristico {

    /**
     * Constructor
     */
    public Comida(String nombreDeLaReserva) {
        super(nombreDeLaReserva);
    }

    /**
     * Metodos
     */
    @Override
    public double calcularPrecioDeReserva() {
        double precioPlato = 200;
        return precioPlato * numeroDeReservas;
    }
}
