package com.company.vehiculo;

public class VehiculoAuto extends Vehiculo{


    /**
     * Constructor.
     *
     * @param velocidad
     * @param aceleracion
     * @param patente
     * @param anguloDeGiro
     */
    public VehiculoAuto(double velocidad, double aceleracion, String patente, double anguloDeGiro) {
        super(velocidad, aceleracion, patente, anguloDeGiro, 1000.0, 4);
    }


}
