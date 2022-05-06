package com.company.paqueteTuristico;

public class BoletoDeViaje extends PaqueteTuristico {


        /**
         * Constructor
         */
    public BoletoDeViaje(String nombreDeLaReserva) {
        super(nombreDeLaReserva);
    }

    /**
     * Metodos
     */
    @Override
    public double calcularPrecioDeReserva() {
        double precioBoleto = 500;
        return numeroDeReservas * precioBoleto;
    }
}
