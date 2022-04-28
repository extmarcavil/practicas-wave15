package com.company.vehiculos;

public class Auto extends Vehiculo{
    public Auto(double velocidad, double aceleracion, int angulogiro, String patente) {
        super(velocidad, aceleracion, angulogiro, patente);
        super.setPeso(1000);
        super.setRuedas(4);
    }
}
