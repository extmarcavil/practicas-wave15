package com;

public class Reserva {

    double precio;
    String tipoReserva;

    public Reserva(double precio, String tipoReserva) {
        this.precio = precio;
        this.tipoReserva = tipoReserva;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getTipoReserva() {
        return tipoReserva;
    }

    public void setTipoReserva(String tipoReserva) {
        this.tipoReserva = tipoReserva;
    }
}
