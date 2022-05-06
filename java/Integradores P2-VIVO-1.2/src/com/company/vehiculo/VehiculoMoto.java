package com.company.vehiculo;

public class VehiculoMoto extends Vehiculo{


    /**
     * Constructor.
     *
     * @param velocidad
     * @param aceleracion
     * @param patente
     * @param anguloDeGiro
     */
    public VehiculoMoto(double velocidad, double aceleracion, String patente, double anguloDeGiro) {
        super(velocidad, aceleracion, patente, anguloDeGiro, 300, 2);
    }


}
