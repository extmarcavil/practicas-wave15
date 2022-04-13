package models;

public class Auto extends Vehiculo {
    public Auto(Float velocidad, Float aceleracion, Float anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente);
        super.peso = 1000F;
        super.ruedas = 4;
    }
}
