package com.company.vehiculos.socorrista;

import com.company.vehiculos.Auto;
import com.company.vehiculos.Moto;
import com.company.vehiculos.Vehiculo;

public class SocorristaAuto extends Vehiculo {

    public SocorristaAuto(String patente) {
        super(patente);
    }

    public void socorrer(Auto auto){
        System.out.println("Se socorrio a el Auto patente: " + auto.getPatente() );
    }
}
