package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Auto auto1 = new Auto(300.0, 700.0, 86.0, "P1", 4, 3000.0);
        Auto auto2 = new Auto(350.0, 750.0, 56.0, "P2", 4, 4000.0);
        Auto auto3 = new Auto(400.0, 400.0, 90.0, "P3", 4, 5000.0);
        Auto auto4 = new Auto(430.0, 800.0, 83.0, "P4", 4, 5800.0);

        Moto moto1 = new Moto(150.0, 59.7, 34.2, "P5", 2, 300.0);
        Moto moto2 = new Moto(50.0, 7.3, 150.0, "P6", 2, 260.0);
        Moto moto3 = new Moto(210.0, 33.7, 190.0, "P7", 2, 600.0);
        Moto moto4 = new Moto(250.0, 70.7, 250.0, "P8", 2, 800.0);

        Carrera carrera = new Carrera(129.5, 1500.0, "C1", 6);

        System.out.println("SE DAN DE ALTA NUEVOS AUTOS");
        carrera.darDeAltaAuto(300.0, 700.0, 86.0, "P1", 4, 3000.0);
        carrera.darDeAltaAuto(350.0, 750.0, 56.0, "P2", 4, 4000.0);
        carrera.darDeAltaAuto(400.0, 400.0, 90.0, "P3", 4, 5000.0);
        carrera.darDeAltaAuto(430.0, 800.0, 83.0, "P4", 4, 5800.0);
        System.out.println();
        System.out.println("SE DAN DE ALTA NUEVAS MOTOS");
        carrera.darDeAltaMoto(150.0, 59.7, 34.2, "P5", 2, 300.0);
        carrera.darDeAltaMoto(50.0, 7.3, 150.0, "P6", 2, 260.0);
        carrera.darDeAltaMoto(210.0, 33.7, 190.0, "P7", 2, 600.0);
        carrera.darDeAltaMoto(250.0, 70.7, 250.0, "P8", 2, 800.0);

        List<Vehiculo> listaVehiculo = new ArrayList<>();
        listaVehiculo.add(auto1);
        listaVehiculo.add(auto2);
        listaVehiculo.add(auto3);
        listaVehiculo.add(auto4);
        listaVehiculo.add(moto1);
        listaVehiculo.add(moto2);
        listaVehiculo.add(moto3);
        listaVehiculo.add(moto4);

        carrera.setListaDeVehiculos(listaVehiculo);
        System.out.println();
        System.out.println("ELIMINO UN AUTO");
        carrera.eliminarVehiculo(auto1);
        System.out.println();
        System.out.println("ELIMINO UNA MOTO");
        carrera.eliminarVehiculo(moto1);
        System.out.println();
        System.out.println("ELIMINO UN AUTO POR PATENTE");
        carrera.eliminarVehiculoConPatente(auto2.getPatente());
        System.out.println();
        System.out.println("ELIMINO UNA MOTO POR PATENTE");
        carrera.eliminarVehiculoConPatente(moto4.getPatente());
        System.out.println();
        System.out.println("SOCORRER VEHICULOS ");
        carrera.socorrerAuto(auto3.getPatente());
        carrera.socorrerAuto(auto4.getPatente());
        carrera.socorrerMoto(moto2.getPatente());
        carrera.socorrerMoto(moto3.getPatente());
        System.out.println();
        carrera.vehiculoGanador(listaVehiculo);
    }
}
