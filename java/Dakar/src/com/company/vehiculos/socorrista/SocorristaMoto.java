package com.company.vehiculos.socorrista;

import com.company.vehiculos.Moto;
import com.company.vehiculos.Vehiculo;

public class SocorristaMoto extends Vehiculo {
    public SocorristaMoto(String patente) {
        super(patente);
    }

    public void socorrer(Moto moto){
        System.out.println("Se socorrio a la Moto patente: " + moto.getPatente() );
    }
}
