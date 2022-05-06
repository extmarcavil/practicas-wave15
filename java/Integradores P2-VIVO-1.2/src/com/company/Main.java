package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here

        /**
         * Creando mi carrera.
         */
        Carrera dakarColombia = new Carrera(200, 10000.0, "DakarColombia", 3);

        // 1. Convocando Vehiculos a mi carrera
        dakarColombia.darDeAltaAuto(250.0, 500, 45, "ABCD");
        dakarColombia.darDeAltaAuto(250.0, 350, 50, "EFGH");
        dakarColombia.darDeAltaAuto(250.0, 350, 60, "ZXYQ");
        //dakarColombia.darDeAltaMoto(200.0, 120.0, 75, "UUY26D");


        // 2. Eliminando un Vehiculo de la carrera con patente.
        dakarColombia.eliminarVehiculoConPatente("EFGH");


        // 3. Conociendo el Ganador.
        System.out.println(dakarColombia.conocerGanador());

        // 4. Socorrer Vehiculo
       dakarColombia.socorrerVehiculo("EFGH");
       dakarColombia.socorrerVehiculo("ABCD");
    }
}
