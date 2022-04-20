package com.company.model.paqueteTuristico;

import com.company.model.Cliente;

public class BoletoViaje extends Reserva{
    private static int contador;
    private int idBoletoViaje;
    private String origen;
    private String destino;
    private Cliente cliente;

    public BoletoViaje(Cliente cliente, double monto , String origen, String destino) {
        super(cliente, monto);
        this.idBoletoViaje = ++this.contador;
        this.origen = origen;
        this.destino = destino;
    }

    public int getIdBoletoViaje() {
        return idBoletoViaje;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    @Override
    public String toString() {
        return "\n      * Datos del Boleto de Viaje: \n" +
                "           - ID del Boleto de Viaje: " + idBoletoViaje + "\n" +
                "           - Origen del Boleto de Viaje: '" + origen + '\'' + "\n" +
                "           - Destino del Boleto de Viaje: '" + destino + '\'';
    }
}
