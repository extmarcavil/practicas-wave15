package model;

import java.util.HashMap;

public class Main {
    public static void main(String args[]){
        Carrera carrera = new Carrera(1000, 5000, 4, "Carrera");
        carrera.darDeAltaAuto(200, 30, 60, "AAA");
        carrera.darDeAltaMoto(140, 15, 30, "BBB");
        carrera.darDeAltaAuto(300, 30, 50, "CCC");
        carrera.darDeAltaMoto(120, 20, 20, "DDD");
        carrera.socorrerAuto("CCC");
        carrera.socorrerMoto("BBB");
        carrera.definirGanador();
    }
}
