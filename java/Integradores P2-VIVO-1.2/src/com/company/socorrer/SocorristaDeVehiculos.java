package com.company.socorrer;

import com.company.vehiculo.Vehiculo;
import com.company.vehiculo.VehiculoAuto;
import com.company.vehiculo.VehiculoMoto;
import jdk.swing.interop.SwingInterOpUtils;

public class SocorristaDeVehiculos implements ISocorrer<Vehiculo> {


    /**
     * Implementando el metodo socorrer de la interfaz.
     *
     * @param vehiculo
     */
    @Override
    public void socorrer(Vehiculo vehiculo) {
        if (vehiculo instanceof VehiculoAuto) {
            System.out.println("Socorriendo el vehiculo tipo Auto con patente: " + vehiculo.getPatente() + "\n");
        } else if (vehiculo instanceof VehiculoMoto) {
            System.out.println("Socorriendo el vehiculo tipo Moto con patente: " + vehiculo.getPatente() + "\n");
        }
    }
}
