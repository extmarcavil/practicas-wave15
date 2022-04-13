package EjerciciosIntegradores.Dakar;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {


        HashMap<String, Vehiculo> lista = new HashMap<>();

        Carrera carrera = new Carrera( 200, 10000, 3, "Dakar", lista  );

        carrera.darDeAltaAuto(120, 160, 80, "AAA");
        carrera.darDeAltaAuto(120, 100, 70, "BBB");
        carrera.darDeAltaAuto(120, 100, 60, "BBB");
        carrera.darDeAltaAuto(120, 100, 60, "CCC");
        carrera.darDeAltaAuto(120, 100, 60, "DDD");


        carrera.getListaDeVehiculos().forEach((k,v) ->
            System.out.println("Performance del auto " + v.getPatente() + ": " + v.getPerformance()));

        System.out.println("El Ganador de la carrera es el " + carrera.definirGanador());
    }
}
