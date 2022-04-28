package com.company.vehiculos;

public class Moto extends Vehiculo{
    public Moto(double velocidad, double aceleracion, int angulogiro, String patente) {
        super(velocidad, aceleracion, angulogiro, patente);
        super.setPeso(300);
        super.setRuedas(2);
    }
}
