package com.company.model.paqueteTuristico;

import com.company.model.Cliente;

public class Comida extends Reserva{
    private String comida;

    public Comida(Cliente cliente, double monto, String comida) {
        super(cliente, monto);
        this.comida = comida;
    }

    public String getComida() {
        return comida;
    }

    public void setComida(String comida) {
        this.comida = comida;
    }

    @Override
    public String toString() {
        return "\n      * Datos de la Comida: " + "\n" +
                "           - Tipo de Comida: '" + comida + '\'';
    }
}
