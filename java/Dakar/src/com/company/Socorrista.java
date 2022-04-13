package com.company;

public class Socorrista extends Vehiculo {

    public Socorrista() {
        super();
    }

    public static void socorrer(Auto veh) {
        System.out.println("Socorriendo auto: " + veh.patente);
    }

    public static void socorrer(Moto veh) {
        System.out.println("Socorriendo moto: " + veh.patente);
    }
}
