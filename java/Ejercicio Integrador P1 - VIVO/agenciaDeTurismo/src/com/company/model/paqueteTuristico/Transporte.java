package com.company.model.paqueteTuristico;

import com.company.model.Cliente;

public class Transporte extends Reserva{
    private static int contador;
    private int idTransporte;
    private String nombreTransporte;
    private String origen;
    private String destino;
    private Cliente cliente;

    public Transporte(Cliente cliente, double monto, String nombreTransporte, String origen, String destino) {
        super(cliente, monto);
        this.idTransporte = ++this.contador;
        this.nombreTransporte = nombreTransporte;
        this.origen = origen;
        this.destino = destino;
    }

    public int getIdTransporte() {
        return idTransporte;
    }

    public String getNombreTransporte() {
        return nombreTransporte;
    }

    public void setNombreTransporte(String nombreTransporte) {
        this.nombreTransporte = nombreTransporte;
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
        return "\n      * Datos del Transporte: " +
                "           - ID del Transporte: " + idTransporte + "\n" +
                "           - Nombre del Transporte: '" + nombreTransporte + '\'' + "\n" +
                "           - Origen del Transporte: '" + origen + '\'' + "\n" +
                "           - Destino del Transporte: '" + destino + '\'';
    }
}
