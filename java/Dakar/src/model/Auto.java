package model;

public class Auto extends Vehiculo{

    public Auto(double velocidad, double aceleracion, double anguloGiro, String patente) {
        super(velocidad, aceleracion, anguloGiro, 1000, 4, patente);
    }
}
